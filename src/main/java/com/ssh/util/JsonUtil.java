package com.ssh.util;

import java.util.ArrayList;
import java.util.List;

import com.ssh.model.PageBean;

import net.sf.json.JSONObject;

public class JsonUtil {

	/**
	 * 后端分页json
	 * @param <T>
	 * @param page 分页数据
	 * @return 分页json
	 */
	public static <T> String PageJson(PageBean<T> page) {
		List<T> list = page.getResults();
		int total = page.getTotalCount();
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("total", total);
		if (list==null){
			jsonBean.put("rows", new ArrayList<T>());
		}else{
			jsonBean.put("rows", list);
		}
		return jsonBean.toString();
	}
	
	public static String JsonSuccess(boolean success, Object obj) {
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("success", success);
		jsonBean.put("msg", obj);
		return jsonBean.toString();
	}
	
	public static String JsonSuccess(boolean success,String dataString) {
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("success", success);
		jsonBean.put("msg", dataString);
		return jsonBean.toString();
	}

	public static String JsonSuccess(boolean success, int obj) {
		JSONObject jsonBean = new JSONObject();
		jsonBean.put("success", success);
		jsonBean.put("msg", obj);
		return jsonBean.toString();
	}

}
