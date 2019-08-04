package com.hxz.stu.controller.teacher;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxz.common.vo.R;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Teacher;
import com.hxz.stu.service.teacher.updateStudentScoreService;

@RequestMapping("/update")
@RestController
public class updateStudentScoreController {

	@Autowired
	private updateStudentScoreService teacherService;

	/**
	 * 这就是spring mvc里面的处理器 /stu/list 处理器返回String的话，springmvc会将这个返回值当做一个页面的文件名字
	 * 
	 * @return
	 */

	@RequestMapping(path = "/listTeacher", method = RequestMethod.GET)

	public R list(HttpServletRequest req, HttpServletResponse resp) {
		String s = (String) req.getSession().getAttribute("id");
		int id = Integer.parseInt(s);
		List<Teacher> stus = teacherService.list(id);
		return new R(true, "",null, stus);
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


	@RequestMapping(path = "/listStuScore", method = RequestMethod.GET)

	public R listStuScore(HttpServletRequest req, HttpServletResponse resp) {
		String s = (String) req.getSession().getAttribute("id");
		int id = Integer.parseInt(s);
		List<Stulesson> stus = teacherService.findStulesson(id);
		return new R(true, "",null, stus);
	}
	
	
	@RequestMapping(path = "/updateScore", method = RequestMethod.POST)
	public R updateScore(Stulesson s){
		R r = null;
		try{
			System.out.println(s.getLscore());
			teacherService.updateScore(s);
			r = new R(true, "保存成功", null);
		}catch(Exception e){
			e.printStackTrace();
			r = new R(false, "保存失败", null);
		}
		
		return r;
	}
	
	@RequestMapping("/findScore")
	public R findScore(String ids) {
		String[] selids = ids.split(",");
		int[] idss = new int[selids.length];
		for (int i = 0; i < selids.length; i++) {
			idss[i] = Integer.parseInt(selids[i]);
		}
		Stulesson s = teacherService.findScore(idss[0],idss[1]);
		return new R(true, "", s);
	}
	
	@RequestMapping("/deletelesson")
	public R deletelesson(String ids) {
		String[] selids = ids.split(",");
		int[] idss = new int[selids.length];
		for (int i = 0; i < selids.length; i++) {
			idss[i] = Integer.parseInt(selids[i]);
		}
	 teacherService.deletelesson(idss[0],idss[1]);
		return new R(true, "", null);
	}
	

}
