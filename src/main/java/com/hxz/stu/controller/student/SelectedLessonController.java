package com.hxz.stu.controller.student;

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
import com.hxz.stu.domain.manager.Lesson;
import com.hxz.stu.service.student.SelectedLessonService;

@RequestMapping("/selected")
@RestController
public class SelectedLessonController {

	@Autowired
	private SelectedLessonService selectedLessonService;
	 

	/**
	 * 这就是spring mvc里面的处理器 /stu/list 处理器返回String的话，springmvc会将这个返回值当做一个页面的文件名字
	 * 
	 * @return
	 */
	@RequestMapping("/listLesson")
	public R list(HttpServletRequest req,HttpServletResponse resp) {
		String s = (String) req.getSession().getAttribute("id");
		int id = Integer.parseInt(s);
		
		List<Lesson> stu = selectedLessonService.list(id);
			
			
		return new R(true, "",null,stu);
	}



	@RequestMapping("/deletelesson/{sid}")
	public R delete(@PathVariable int sid,HttpServletRequest req,HttpServletResponse resp) {
		String s = (String) req.getSession().getAttribute("id");
		int id = Integer.parseInt(s);
		System.out.println(id);
		System.out.println(sid);
		selectedLessonService.delete(id,sid);
		return new R(true, "", null);
	}
	
	@RequestMapping(path = "/mdeletelesson", method = RequestMethod.POST)
	public R mdelete(String ids,HttpServletRequest req,HttpServletResponse resp) {
		String s = (String) req.getSession().getAttribute("id");
		int id = Integer.parseInt(s);
		String[] selids = ids.split(",");
		int[] idss = new int[selids.length];
		for (int i = 0; i < selids.length; i++) {
			idss[i] = Integer.parseInt(selids[i]);
		}
		selectedLessonService.mdelete(id,idss);
		return new R(true, "", null);
	}
	
	@RequestMapping("/selectScore")
	public R get(HttpServletRequest req, HttpServletResponse resp) {
		String s = (String) req.getSession().getAttribute("id");
		int id = Integer.parseInt(s);
		List<Stulesson> s1 = selectedLessonService.findScore(id);
		
		return new R(true, "",null, s1);
	}

}
