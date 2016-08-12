package provider.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.SysMenu;
import model.SysMenuBean;
import model.SysRoleMenu;
import model.SysUserMenu;
import model.SysUserRole;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
public class SysAuthorizeProviderImpl extends BaseProviderImpl<SysMenu> {
	private SysMenuProviderImpl sysMenuService;

	@Transactional
	@CacheEvict(value = "getAuthorize", allEntries = true)
	public void updateUserMenu(List<SysUserMenu> sysUserMenus) {
	}

	@Transactional
	@CacheEvict(value = "getAuthorize", allEntries = true)
	public void updateUserRole(List<SysUserRole> sysUserRoles) {
	}

	@Transactional
	@CacheEvict(value = "getAuthorize", allEntries = true)
	public void updateRoleMenu(List<SysRoleMenu> sysRoleMenus) {
	}

	@Cacheable(value = "getAuthorize")
	public List<SysMenuBean> queryAuthorizeByUserId(Integer userId) {
		List<Integer> menuIds = new ArrayList<Integer>();
		List<SysMenuBean> menus = getList(menuIds, SysMenuBean.class);
		Map<Integer, List<SysMenuBean>> map = new HashMap<Integer, List<SysMenuBean>>();
		for (SysMenuBean sysMenuBean : menus) {
			if (map.get(sysMenuBean.getParentId()) == null) {
				List<SysMenuBean> menuBeans = new ArrayList<SysMenuBean>();
				map.put(sysMenuBean.getParentId(), menuBeans);
			}
			map.get(sysMenuBean.getParentId()).add(sysMenuBean);
		}
		List<SysMenuBean> result = new ArrayList<SysMenuBean>();
		for (SysMenuBean sysMenuBean : menus) {
			if (sysMenuBean.getParentId() == 0) {
				sysMenuBean.setMenuBeans(getChildMenu(map, sysMenuBean.getId()));
				result.add(sysMenuBean);
			}
		}
		return result;
	}

	// 递归获取子菜单
	private List<SysMenuBean> getChildMenu(Map<Integer, List<SysMenuBean>> map, Integer id) {
		List<SysMenuBean> menus = map.get(id);
		if (menus != null) {
			for (SysMenuBean sysMenuBean : menus) {
				sysMenuBean.setMenuBeans(getChildMenu(map, sysMenuBean.getId()));
			}
		}
		return menus;
	}

	public SysMenu queryById(Integer id) {
		return sysMenuService.queryById(id);
	}
}
