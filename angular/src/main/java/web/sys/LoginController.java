package web.sys;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import enums.HttpCode;

import service.sys.SysUserService;

/**
 * 用户登录
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:11:21
 */
@RestController
public class LoginController extends BaseController{
	//@Autowired
	private SysUserService sysUserService;

	// 登录
	@RequestMapping(value = "/login")
	public Object login(ModelMap modelMap, @RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "password", required = false) String password) {
//		Assert.notNull(account, Resources.getMessage("ACCOUNT_IS_NULL"));
//		Assert.notNull(password, Resources.getMessage("PASSWORD_IS_NULL"));
//		if (LoginHelper.login(account, sysUserService.encryptPassword(password))) {
//			
//		}
		return setSuccessModelMap(modelMap);
		//throw new LoginException(Resources.getMessage("LOGIN_FAIL"));
	}

	// 登出
	@RequestMapping("/logout")
	public Object logout(ModelMap modelMap) {
		return setSuccessModelMap(modelMap);
	}

	// 注册
	@RequestMapping(value = "/regin")
	public Object regin(HttpServletRequest request, ModelMap modelMap,
			@RequestParam(value = "account", required = false) String account,
			@RequestParam(value = "password", required = false) String password) {
		return setSuccessModelMap(modelMap);
	}

	// 没有登录
	@RequestMapping("/unauthorized")
	public Object unauthorized(ModelMap modelMap) {
		return setModelMap(modelMap, HttpCode.UNAUTHORIZED);
	}

	// 没有权限
	@RequestMapping("/forbidden")
	public Object forbidden(ModelMap modelMap) {
		return setModelMap(modelMap, HttpCode.FORBIDDEN);
	}
}
