package web.sys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.SysDept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.sys.SysDeptService;

import com.github.pagehelper.PageInfo;

/**
 * 部门管理控制类
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:13:31
 */
@RestController
@RequestMapping("dept")
public class SysDeptController extends BaseController {
	private SysDeptService sysDeptService;

	// 查询部门
	@RequestMapping(value = "/read/list")
	public Object get(HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageInfo<?> list = sysDeptService.query(params);
		return setSuccessModelMap(modelMap, list);
	}

	// 详细信息
	@RequestMapping(value = "/read/detail")
	public Object detail(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
		SysDept record = new SysDept();
		return setSuccessModelMap(modelMap, record);
	}

	// 新增部门
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Object add(HttpServletRequest request, ModelMap modelMap) {
		SysDept record = new SysDept();
		return setSuccessModelMap(modelMap);
	}

	// 修改部门
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Object update(HttpServletRequest request, ModelMap modelMap) {
		SysDept record = new SysDept();
		return setSuccessModelMap(modelMap);
	}

	// 删除部门
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public Object delete(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "id", required = false) Integer id) {
		return setSuccessModelMap(modelMap);
	}
}
