package com.hxz.stu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxz.common.vo.R;
import com.hxz.stu.domain.User;
import com.hxz.stu.domain.manager.Student;
import com.hxz.stu.domain.manager.Teacher;
import com.hxz.stu.service.LoginService;
import com.hxz.stu.service.manager.StudentService;
import com.hxz.stu.service.manager.TeacherService;

@RequestMapping("/Login")
@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping(path = "/Managercheck", method = RequestMethod.POST)
	public R check(User s, HttpServletRequest req, HttpServletResponse resp) {
		R r = new R(false, "登陆失败,请检查登录名或密码", null);
		if (loginService.ManagerCheck(s)) {
			req.getSession().setAttribute("username", s.getUsername());
			r = new R(true, "登陆成功", null);
		}
		return r;
	}

	@RequestMapping(path = "/Teachercheck", method = RequestMethod.POST)
	public R TeacherCheck(User s, HttpServletRequest req, HttpServletResponse resp) {
		Teacher s1 = new Teacher(Integer.parseInt(s.getUsername()), s.getPassword());
		Teacher t = loginService.findTeacher(Integer.parseInt(s.getUsername()));
		R r = new R(false, "登陆失败,请检查登录名或密码", null);
		if (loginService.TeacherCheck(s1)) {
			req.getSession().setAttribute("id", s.getUsername());
			req.getSession().setAttribute("username", t.getTname());
			r = new R(true, "登陆成功", null);
		}
		return r;
	}

	@RequestMapping(path = "/Studentcheck", method = RequestMethod.POST)
	public R StudentCheck(User s, HttpServletRequest req, HttpServletResponse resp) {
		Student s1 = new Student(Integer.parseInt(s.getUsername()), s.getPassword());
		R r = new R(false, "登陆失败,请检查登录名或密码", null);	
		Student t = loginService.findStudent(Integer.parseInt(s.getUsername()));
		if (loginService.studentCheck(s1)) {
			r = new R(true, "登陆成功", null);			
			req.getSession().setAttribute("id", s.getUsername());
			req.getSession().setAttribute("username", t.getSname());
		}
		return r;
	}
}