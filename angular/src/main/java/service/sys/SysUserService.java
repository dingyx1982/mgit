package service.sys;

import java.util.Map;

import model.SysUser;
import model.SysUserBean;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:47:21
 */
@Service
public class SysUserService extends BaseService<SysUser> {

	/** 修改用户信息 */
	@CachePut
	public void updateUserInfo(SysUser sysUser) {
		SysUser user = this.queryById(sysUser.getId());
		if (StringUtils.isBlank(sysUser.getPassword())) {
			sysUser.setPassword(user.getPassword());
		}
		
	}

	public PageInfo<SysUserBean> queryBeans(Map<String, Object> params) {
		return null;
	}

	public void updatePassword(Integer id, String password) {
	}

	public String encryptPassword(String password) {
		return null;
	}

	public void thirdPartyLogin() {}

}
