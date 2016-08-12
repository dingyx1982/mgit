package provider.sys;

import java.util.Map;

import model.SysDic;
import model.SysMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
public class SysMenuProviderImpl extends BaseProviderImpl<SysMenu> {
	private SysDicProviderImpl sysDicService;

	@Cacheable
	public SysMenu queryById(Integer id) {
		return null;
	}

	@CachePut
	public SysMenu update(SysMenu record) {
		return null;
	}

	@CacheEvict
	public void delete(Integer id) {
	}

	public PageInfo<SysMenu> query(Map<String, Object> params) {
		this.startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysMenu> pageInfo = getPage(userIds, SysMenu.class);
		Map<String, String> menuTypeMap = sysDicService.queryDicByDicIndexKey("MENUTYPE");
		for (SysMenu sysMenu : pageInfo.getList()) {
			if (sysMenu.getMenuType() != null) {
				sysMenu.setRemark(menuTypeMap.get(sysMenu.getMenuType().toString()));
			}
		}
		return pageInfo;
	}

}
