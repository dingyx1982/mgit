package web.sys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.SysMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.sys.SysMenuService;

import com.github.pagehelper.PageInfo;

/**
 * 菜单管理
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:14:54
 */
@RestController
@RequestMapping("menu")
public class SysMenuController extends BaseController {

	private SysMenuService sysMenuService;
	
	// 查询菜单
	@RequestMapping(value = "/read/list")
	public Object get(HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageInfo<?> list = sysMenuService.query(params);
		return setSuccessModelMap(modelMap, list);
	}

	// 详细信息
	@RequestMapping(value = "/read/detail")
	public Object detail(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
		SysMenu record = new SysMenu();
		return setSuccessModelMap(modelMap, record);
	}

	// 新增菜单
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(HttpServletRequest request, ModelMap modelMap) {
		SysMenu record = new SysMenu();
		//sysMenuService.add(record);
		return setSuccessModelMap(modelMap);
	}

	// 修改菜单
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(HttpServletRequest request, ModelMap modelMap) {
		SysMenu record = new SysMenu();;
		//sysMenuService.update(record);
		return setSuccessModelMap(modelMap);
	}

	// 删除菜单
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Object delete(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "id", required = false) Integer id) {
		//sysMenuService.delete(id);
		return setSuccessModelMap(modelMap);
	}
}
