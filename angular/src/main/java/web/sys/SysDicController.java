package web.sys;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import model.SysDic;
import model.SysDicIndex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import service.sys.SysDicService;

import com.github.pagehelper.PageInfo;

/**
 * 字典管理
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:14:34
 */
@RestController
public class SysDicController extends BaseController {
	private SysDicService sysDicService;

	// 查询字典
	@RequestMapping(value = "dicIndex/read/list")
	public Object getDicIndex(HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageInfo<?> list = sysDicService.queryDicIndex(params);
		return setSuccessModelMap(modelMap, list);
	}

	// 详细信息
	@RequestMapping(value = "dicIndex/read/detail")
	public Object detail(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
		SysDicIndex record = sysDicService.queryDicIndexById(id);
		return setSuccessModelMap(modelMap, record);
	}

	// 新增字典
	@RequestMapping(value = "dicIndex/add", method = RequestMethod.POST)
	public Object addDicIndex(HttpServletRequest request, ModelMap modelMap) {
		SysDicIndex record = new SysDicIndex();
		sysDicService.addDicIndex(record);
		return setSuccessModelMap(modelMap);
	}

	// 修改字典
	@RequestMapping(value = "dicIndex/update", method = RequestMethod.POST)
	public Object updateDicIndex(HttpServletRequest request, ModelMap modelMap) {
		SysDicIndex record = new SysDicIndex();
		sysDicService.updateDicIndex(record);
		return setSuccessModelMap(modelMap);
	}

	// 删除字典
	@RequestMapping(value = "dicIndex/delete", method = RequestMethod.POST)
	public Object deleteDicIndex(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "id", required = false) Integer id) {
		sysDicService.deleteDicIndex(id);
		return setSuccessModelMap(modelMap);
	}

	// 查询字典
	@RequestMapping(value = "dic/read/list")
	public Object getDic(HttpServletRequest request, ModelMap modelMap) {
		Map<String, Object> params = new HashMap<String, Object>();
		PageInfo<?> list = sysDicService.queryDic(params);
		return setSuccessModelMap(modelMap, list);
	}

	// 详细信息
	@RequestMapping(value = "dic/read/detail")
	public Object dicDetail(ModelMap modelMap, @RequestParam(value = "id", required = false) Integer id) {
		SysDic record = sysDicService.queryDicById(id);
		return setSuccessModelMap(modelMap, record);
	}

	// 新增字典
	@RequestMapping(value = "dic/add", method = RequestMethod.POST)
	public Object addDic(HttpServletRequest request, ModelMap modelMap) {
		SysDic record = new SysDic();
		sysDicService.addDic(record);
		return setSuccessModelMap(modelMap);
	}

	// 修改字典
	@RequestMapping(value = "dic/update", method = RequestMethod.POST)
	public Object updateDic(HttpServletRequest request, ModelMap modelMap) {
		SysDic record = new SysDic();
		sysDicService.updateDic(record);
		return setSuccessModelMap(modelMap);
	}

	// 删除字典
	@RequestMapping(value = "dic/delete", method = RequestMethod.POST)
	public Object deleteDic(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "id", required = false) Integer id) {
		sysDicService.deleteDic(id);
		return setSuccessModelMap(modelMap);
	}
}
