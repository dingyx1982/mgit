package service.sys;

import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageInfo;

/**
 * @author ShenHuaJie
 * @version 2016年5月20日 下午3:16:20
 */
@Service
public class SchedulerService {


	public boolean execTask(String taskGroup, String taskName) {
		return false;
	}

	public boolean openTask(String taskGroup, String taskName) {
		return false;}

	public boolean closeTask(String taskGroup, String taskName) {
		return false;}



}
