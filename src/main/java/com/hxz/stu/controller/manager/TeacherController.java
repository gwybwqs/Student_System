package com.hxz.stu.controller.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.common.vo.R;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Teacher;
import com.hxz.stu.service.manager.TeacherService;

@RequestMapping("/Teacher")
@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	/**
	 * 这就是spring mvc里面的处理器 /stu/list 处理器返回String的话，springmvc会将这个返回值当做一个页面的文件名字
	 * 
	 * @return
	 */

	@RequestMapping(path = "/listTeacher", method = RequestMethod.GET)

	public R list(PageParam p) {
		Page<Teacher> stus = teacherService.list(p);
		return new R(true, "", null, stus.total, stus.rows);
	}

	/**
	 * 这就是spring mvc里面的处理器
	 * 
	 * @return
	 */
	@RequestMapping(path = "/addTeacher", method = RequestMethod.POST)

	public R save(Teacher s) {
		R r = null;
		try{
			teacherService.save(s);
			r = new R(true, "保存成功", null);
		}catch(Exception e){
			r = new R(false, "保存失败", null);
		}
		
		return r;
	}

	@RequestMapping("/findTeacher/{id}")

	public R get(@PathVariable int id) {
		Teacher s = teacherService.findById(id);
		return new R(true, "", s);
	}

	@RequestMapping(path = "/updateTeacher", method = RequestMethod.POST)

	public R update(Teacher s) {
		R r = null;
		try{
			teacherService.update(s);
			r = new R(true, "保存成功", null);
		}catch(Exception e){
			r = new R(false, "保存失败", null);
		}
		
		return r;
	}

	@RequestMapping(path = "/deleteTeacher/{id}")
	public R delete(@PathVariable int id) {
		teacherService.delete(id);
		return new R(true, "", null);
	}

	@RequestMapping(path = "/mdeleteTeacher/{selid}", method = RequestMethod.POST)

	public R mdelete(@PathVariable String selid) {
		String[] ids = selid.split(",");
		int[] idss = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			idss[i] = Integer.parseInt(ids[i]);
		}
		teacherService.mdelete(idss);
		return new R(true, "", null);
	}

}
