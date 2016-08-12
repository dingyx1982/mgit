/**
 * 
 */
package provider.sys;

import java.util.Date;
import java.util.Map;

import model.SysUser;
import model.SysUserBean;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:19:19
 */
@CacheConfig(cacheNames = "sysUser")
public class SysUserProviderImpl extends BaseProviderImpl<SysUser> {
	private SysDeptProviderImpl deptService;

	@CachePut
	@Transactional
	public SysUser update(SysUser record) {
		if (record.getId() == null) {
			record.setUsable(1);
			record.setCreateTime(new Date());
			//sysUserMapper.insert(record);
		} else {
			//sysUserMapper.updateByPrimaryKey(record);
		}
		return record;
	}

	@CachePut
	@Transactional
	public void delete(Integer id) {}

	@Cacheable
	public SysUser queryById(Integer id) {
		return new SysUser();
	}

	public PageInfo<SysUser> query(Map<String, Object> params) {
		return null;
	}

	public PageInfo<SysUserBean> queryBeans(Map<String, Object> params) {
		this.startPage(params);
		Page<Integer> userIds = new Page<Integer>();
		PageInfo<SysUserBean> pageInfo = getPage(userIds, SysUserBean.class);
		return pageInfo;
	}

	/** 查询第三方帐号用户Id */
	@Cacheable
	public String queryUserIdByThirdParty(String openId, String provider) {
		return null;
	}

	// 加密
	public String encryptPassword(String password) {
		return null;
	}

	/** 保存第三方帐号 */
	@Transactional
	public SysUser insertThirdPartyUser() {
		return null;
	}
}
