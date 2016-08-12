package service.sys;

import java.util.Map;

import model.SysDic;
import model.SysDicIndex;

import org.springframework.stereotype.Service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;

@Service
public class SysDicService {

	public PageInfo<SysDicIndex> queryDicIndex(Map<String, Object> params) {
		return null;
	}

	public PageInfo<SysDic> queryDic(Map<String, Object> params) {
		return null;
	}

	public void addDicIndex(SysDicIndex record) {
		
	}

	public void updateDicIndex(SysDicIndex record) {
	}

	public void deleteDicIndex(Integer id) {
	}

	public void addDic(SysDic record) {
	}

	public void updateDic(SysDic record) {
	}

	public void deleteDic(Integer id) {
	}

	public SysDicIndex queryDicIndexById(Integer id) {
		return null;
	}

	public SysDic queryDicById(Integer id) {
		return null;
	}
}
