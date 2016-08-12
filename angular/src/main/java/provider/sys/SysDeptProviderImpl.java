package provider.sys;

import java.util.Map;

import model.SysDept;
import model.SysDic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
@CacheConfig(cacheNames = "sysDept")
public class SysDeptProviderImpl extends BaseProviderImpl<SysDept> {

	@CachePut
	@Transactional
	public SysDept update(SysDept record) {
		return record;
	}

	@CachePut
	@Transactional
	public void delete(Integer id) {
		SysDept record = queryById(id);
		record.setEnable(0);
		update(record);
	}

	@Cacheable
	public SysDept queryById(Integer id) {
		return null;
	}

	public PageInfo<SysDept> query(Map<String, Object> params) {
		this.startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysDept> pageInfo = getPage(userIds, SysDept.class);
		return pageInfo;
	}
}
