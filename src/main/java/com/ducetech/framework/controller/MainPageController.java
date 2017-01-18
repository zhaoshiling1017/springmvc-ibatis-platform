package com.ducetech.framework.controller;

import com.ducetech.framework.model.User;
import com.ducetech.framework.service.DepartmentService;
import com.ducetech.framework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


/**
 * 
* @ClassName: MainPageController 
* @Description: 系统主页Controller 
* @author chensf
* @date 2016年9月18日 下午5:38:26 
*
 */
@Controller
public class MainPageController extends BaseController {

	@Autowired
	private UserService userService;
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String testPager(Model model, HttpServletRequest request) {
		User user = getLoginUser(request);
		return "main";
	}
}
