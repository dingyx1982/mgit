/**
 * 
 */
package web.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.SysMenuBean;
import model.SysUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.sys.SysAuthorizeService;
import service.sys.SysUserService;

import com.github.pagehelper.PageInfo;

/**
 * 用户管理控制器
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:12:12
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController {
	private SysUserService sysUserService;
	private SysAuthorizeService authorizeService;

	// 修改用户信息
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(HttpServletRequest request, ModelMap modelMap) {
		SysUser sysUser = new SysUser();
		sysUserService.updateUserInfo(sysUser);
		return setSuccessModelMap(modelMap);
	}

	// 修改密码
	@RequestMapping(value = "/update/password", method = RequestMethod.POST)
	public Object updatePassword(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "password", required = false) String password) {
		sysUserService.updatePassword(id, password);
		return setSuccessModelMap(modelMap);
	}

	// 查询用户
	@RequestMapping(value = "/read/list")
	public Object get(HttpServletRequest request, ModelMap modelMap) {
		PageInfo<SysUser> list = new PageInfo<SysUser>();
		List<SysUser> userList = new ArrayList<SysUser>();
		SysUser user = new SysUser();
		user.setId(1);
		user.setUserName("admin");
		user.setPhone("13111111111");
		user.setSex(1);
		userList.add(user);
		list.setList(userList);
		list.setPageNum(1);
		list.setPages(10);
		list.setSize(1);
		list.setTotal(1);
		return setSuccessModelMap(modelMap, list);
	}

	// 用户详细信息
	@RequestMapping(value = "/read/detail")
	public Object detail(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
		SysUser sysUser = sysUserService.queryById(id);
		if (sysUser != null) {
			sysUser.setPassword(null);
		}
		return setSuccessModelMap(modelMap, sysUser);
	}

	// 当前用户
	@RequestMapping(value = "/read/current")
	public Object current(ModelMap modelMap) {
		SysUser sysUser = new SysUser();
		if (sysUser != null) {
			sysUser.setId(1);
			sysUser.setUserName("管理员");
			sysUser.setPassword(null);
		}
		List<SysMenuBean> menus = new ArrayList<SysMenuBean>();

		SysMenuBean menuBean = new SysMenuBean();
		menuBean.setId(1);
		menuBean.setMenuName("系统管理");
		menuBean.setParentId(null);
		menuBean.setMenuType(0);
		menuBean.setRequest("");
		menuBean.setLeaf(0);
			List<SysMenuBean> submenus = new ArrayList<SysMenuBean>();
			SysMenuBean submenuBean = new SysMenuBean();
			submenuBean.setId(11);
			submenuBean.setMenuName("用户管理");
			submenuBean.setParentId(menuBean.getId());
			submenuBean.setMenuType(1);
			submenuBean.setRequest("main.sys.user.list");
			submenuBean.setLeaf(1);
			submenus.add(submenuBean);
			
			submenuBean = new SysMenuBean();
			submenuBean.setId(12);
			submenuBean.setMenuName("角色管理");
			submenuBean.setParentId(menuBean.getId());
			submenuBean.setMenuType(1);
			submenuBean.setRequest("main.sys.user.create");
			submenuBean.setLeaf(1);
			submenus.add(submenuBean);
			menuBean.setMenuBeans(submenus);
		menus.add(menuBean);
		
		menuBean = new SysMenuBean();
		menuBean.setId(2);
		menuBean.setMenuName("流程管理");
		menuBean.setParentId(null);
		menuBean.setMenuType(0);
		menuBean.setRequest("");
		menuBean.setLeaf(0);
			List<SysMenuBean> submenus2 = new ArrayList<SysMenuBean>();
			SysMenuBean submenuBean2 = new SysMenuBean();
			submenuBean2.setId(21);
			submenuBean2.setMenuName("流程角色");
			submenuBean2.setParentId(menuBean.getId());
			submenuBean2.setMenuType(1);
			submenuBean2.setRequest("/processRole/read/list");
			submenuBean2.setLeaf(1);
			submenus2.add(submenuBean2);
			
			submenuBean2 = new SysMenuBean();
			submenuBean2.setId(22);
			submenuBean2.setMenuName("流程监控");
			submenuBean2.setParentId(menuBean.getId());
			submenuBean2.setMenuType(1);
			submenuBean2.setRequest("/processMonitor/read/list");
			submenuBean2.setLeaf(1);
			submenus2.add(submenuBean2);
			menuBean.setMenuBeans(submenus2);
		menus.add(menuBean);
		
		modelMap.put("user", sysUser);
		modelMap.put("menus", menus);
		return setSuccessModelMap(modelMap);
	}
}
