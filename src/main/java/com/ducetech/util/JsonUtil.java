package com.ducetech.util;


import javax.servlet.http.HttpServletRequest;

import com.ducetech.framework.json.CustomObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.alibaba.fastjson.JSON;
import com.ducetech.framework.model.Query;


public class JsonUtil {

	private static ObjectMapper objectMapper = new CustomObjectMapper();

	/**
	 * 将 POJO 对象转为 JSON 字符串
	 */
	public static <T> String toJson(T pojo) {
		String json;
		try {
			json = objectMapper.writeValueAsString(pojo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return json;
	}

	/**
	 * 将 JSON 字符串转为 POJO 对象
	 */
	public static <T> T fromJson(String json, Class<T> type) {
		T pojo;
		try {
			pojo = objectMapper.readValue(json, type);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return pojo;
	}
	
	public  static <T> Query<T> getSearchCondition(Class<T> clazz, HttpServletRequest request) throws Exception{
		int page = Integer.parseInt(request.getParameter("page"));
		int rows = Integer.parseInt(request.getParameter("rows"));
		String search = request.getParameter("search");
		T t = JSON.parseObject(search, clazz);
        Query<T> query = new Query<T>(t);
        query.setPage(page);
        query.setRows(rows);
		return query;
	}
}

