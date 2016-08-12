package service.sys;

import model.SysPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:13
 */
@Service
public class SysPermissionService extends BaseService<SysPermission> {

	public Boolean doCheckPermissionByUserId(Integer userId, String url) {
		return false;
	}
}
