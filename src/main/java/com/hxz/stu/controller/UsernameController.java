package com.hxz.stu.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hxz.common.vo.R;
import com.hxz.stu.domain.User;

@RequestMapping("/user")
@Controller
public class UsernameController {
	@RequestMapping(path = "/username", method = RequestMethod.GET)
	@ResponseBody
	public R check(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String s = (String) req.getSession().getAttribute("username");
		Map<String, String> data = new HashMap<String, String>();
		R r = null;
		if(s == null){
			data.put("url", "/static/login.html");
			 r = new R(false, "未登录", data);
		}else{
			data.put("username", s);
			 r = new R(true, "", data);
		}
		return r;
	}
}
