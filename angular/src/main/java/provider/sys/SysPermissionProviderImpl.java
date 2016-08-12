package provider.sys;

import java.util.Map;

import model.SysPermission;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * URL权限管理
 * 
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:49
 */
@CacheConfig(cacheNames = "sysPermission")
public class SysPermissionProviderImpl extends BaseProviderImpl<SysPermission> {

	@Cacheable
	public boolean doCheckPermissionByUserId(Integer userId, String url) {
		return false;
	}

	@Cacheable
	public SysPermission queryById(Integer id) {
		return null;
	}

	@CachePut
	public SysPermission update(SysPermission record) {
		return null;
	}

	@CacheEvict
	public void delete(Integer id) {
	}

	public PageInfo<SysPermission> query(Map<String, Object> params) {
		startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysPermission> pageInfo = getPage(userIds, SysPermission.class);
		return pageInfo;
	}
}
