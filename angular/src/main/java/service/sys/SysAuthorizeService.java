package service.sys;

import java.util.List;

import model.SysMenuBean;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:00
 */
@Service
public class SysAuthorizeService {

	public List<SysMenuBean> queryAuthorizeByUserId(Integer id) {
		return null;
	}

}
