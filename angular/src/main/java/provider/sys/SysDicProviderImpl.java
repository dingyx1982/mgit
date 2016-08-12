package provider.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.SysDic;
import model.SysDicIndex;
import model.SysPermission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
public class SysDicProviderImpl extends BaseProviderImpl<SysDic> {

	@Transactional
	@CachePut(value = "sysDicIndex")
	public void updateDicIndex(SysDicIndex record) {
	}

	@Transactional
	@CachePut(value = "sysDic")
	public void updateDic(SysDic record) {
	}

	@Transactional
	@CacheEvict(value = "sysDic")
	public void deleteDic(Integer id) {
	}

	@Cacheable(value = "sysDicIndex")
	public SysDicIndex queryDicIndexById(Integer id) {
		return null;
	}

	@Cacheable(value = "sysDic")
	public SysDic queryDicById(Integer id) {
		return null;
	}

	@CacheEvict(value = "sysDics", allEntries = true)
	public void clearCache() {
	}

	@Cacheable(value = "sysDics")
	public Map<String, Map<String, String>> queryAllDic() {
		List<SysDicIndex> sysDicIndexs = new ArrayList<SysDicIndex>();
		Map<Integer, String> dicIndexMap = new HashMap<Integer, String>();
		for (SysDicIndex sysDicIndex : sysDicIndexs) {
			dicIndexMap.put(sysDicIndex.getId(), sysDicIndex.getKey());
		}
		List<SysDic> sysDics = new ArrayList<SysDic>();
		Map<String, Map<String, String>> resultMap = new HashMap<String, Map<String,String>>();
		for (SysDic sysDic : sysDics) {
			String key = dicIndexMap.get(sysDic.getIndexId());
			if (resultMap.get(key) == null) {
				Map<String, String> dicMap = new HashMap<String, String>();
				resultMap.put(key, dicMap);
			}
			resultMap.get(key).put(sysDic.getCode(), sysDic.getCodeText());
		}
		return resultMap;
	}

	@Cacheable(value = "sysDicMap")
	public Map<String, String> queryDicByDicIndexKey(String key) {
		return queryAllDic().get(key);
	}

	public SysDic queryById(Integer id) {
		return queryDicById(id);
	}

	public PageInfo<SysDicIndex> queryDicIndex(Map<String, Object> params) {
		startPage(params);
		Page<Integer> ids = new Page<Integer>();
		Page<SysDicIndex> page = new Page<SysDicIndex>(ids.getPageNum(), ids.getPageSize());
		page.setTotal(ids.getTotal());
		if (ids != null) {
			page.clear();
			for (Integer id : ids) {
			}
		}
		return new PageInfo<SysDicIndex>(page);
	}

	public PageInfo<SysDic> queryDic(Map<String, Object> params) {
		startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysDic> pageInfo = getPage(userIds, SysDic.class);
		return pageInfo;
	}

	public void deleteDicIndex(Integer id) {
	}
}
