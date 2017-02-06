package com.ducetech.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ducetech.api.security.IgnoreSecurity;
import com.ducetech.util.DateUtil;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.util.Date;

@Controller
public class IndexController extends BaseController implements EnvironmentAware {

	private Environment env;

	@RequestMapping("/")
	public String index(HttpServletRequest request, Model model) {
		getLoginUser(request, model);
		return "index";
	}

	@RequestMapping("/notify")
	public String notify(HttpServletRequest request, Model model) {
		getLoginUser(request, model);
		return "index";
	}

	@RequestMapping(value = "/404", method = RequestMethod.GET)
	public String notFound() {
		return "404";
	}
	@RequestMapping(value = "/500", method = RequestMethod.GET)
	public String error() {
		return "500";
	}

	/**
	 * @Title: getDate
	 * @param response
	 * @throws java.io.IOException
	 * @Description: 获取当前时间
	 */
	@RequestMapping(value = "/getDate", method = RequestMethod.GET)
	public void getDate(HttpServletResponse response) throws IOException {
		response.getWriter().write(JSON.toJSONString(DateUtil.dateTimeToString(new Date())));
	}

	@Override
	public void setEnvironment(Environment environment) {
		this.env = environment;
	}
}
