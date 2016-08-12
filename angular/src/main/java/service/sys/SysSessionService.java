package service.sys;

import java.util.List;
import java.util.Map;

import model.SysSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

/**
 * 会话管理
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:08:32
 */
@Service
public class SysSessionService {

	public PageInfo<?> query(Map<String, Object> params) {
		return null;
	}

	/** 删除会话 */
	public void deleteByAccount(String account) {}

	/** 删除会话 */
	public void delete(Integer id) {}

	/** 更新会话 */
	public void update(SysSession record) {}

	/** 删除会话 */
	public void deleteBySessionId(String sessionId) {}

}
