package provider.sys;

import java.util.Map;

import model.SysParam;
import model.SysSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月31日 上午11:01:33
 */
@CacheConfig(cacheNames = "sysParam")
public class SysParamProviderImpl extends BaseProviderImpl<SysParam> {

	@CachePut
	public SysParam update(SysParam record) {
		return null;
	}

	@CacheEvict
	public void delete(Integer id) {
	}

	public PageInfo<SysParam> query(Map<String, Object> params) {
		startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysParam> pageInfo = getPage(userIds, SysParam.class);
		return pageInfo;
	}

	@Cacheable
	public SysParam queryById(Integer id) {
		return null;
	}

}
