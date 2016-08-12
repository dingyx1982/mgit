package provider.sys;

import java.util.List;
import java.util.Map;

import model.SysSession;
import model.SysUserBean;

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
@CacheConfig(cacheNames = "sysSession")
public class SysSessionProviderImpl extends BaseProviderImpl<SysSession> {

	@CachePut
	public SysSession update(SysSession record) {
		return null;
	}

	@CacheEvict
	public void delete(Integer id) {
	}

	// 系统触发,由系统自动管理缓存
	public void deleteBySessionId(final String sessionId) {
	}

	@Cacheable
	public SysSession queryById(Integer id) {
		return null;
	}

	public PageInfo<SysSession> query(Map<String, Object> params) {
		this.startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysSession> pageInfo = getPage(userIds, SysSession.class);
		return pageInfo;
	}

	public List<String> querySessionIdByAccount(String account) {
		return null;
	}
}
