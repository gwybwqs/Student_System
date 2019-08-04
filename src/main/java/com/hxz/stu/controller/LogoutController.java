package com.hxz.stu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/Log")
@Controller
public class LogoutController {
	@RequestMapping("/logout")
	protected void Logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().removeAttribute("username");
		resp.setContentType("text/html; charset=utf8");
		resp.sendRedirect("/static/login.html");
	}
}