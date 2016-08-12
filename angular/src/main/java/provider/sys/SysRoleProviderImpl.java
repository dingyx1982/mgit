package provider.sys;

import java.util.Map;

import model.SysRole;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月31日 上午11:01:33
 */
public class SysRoleProviderImpl extends BaseProviderImpl<SysRole>  {

	@CachePut
	public SysRole update(SysRole record) {
		return null;
	}

	@CacheEvict
	public void delete(Integer id) {
	}

	public PageInfo<SysRole> query(Map<String, Object> params) {
		startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysRole> pageInfo = getPage(userIds, SysRole.class);
		return pageInfo;
	}

	@Cacheable
	public SysRole queryById(Integer id) {
		return null;
	}

}
