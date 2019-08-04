package com.hxz.stu.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.common.vo.R;
import com.hxz.stu.domain.manager.Lesson;
import com.hxz.stu.service.manager.LessonService;

@RequestMapping("/lesson")
@RestController
public class LessonController {

	@Autowired
	private LessonService lessonService;

	/**
	 * 这就是spring mvc里面的处理器 /stu/list 处理器返回String的话，springmvc会将这个返回值当做一个页面的文件名字
	 * 
	 * @return
	 */

	@RequestMapping(path = "/listLesson", method = RequestMethod.GET)

	public R list(PageParam p) {
		Page<Lesson> stus = lessonService.list(p);
		return new R(true, "", null, stus.total, stus.rows);
	}

	/**
	 * 这就是spring mvc里面的处理器
	 * 
	 * @return
	 */
	@RequestMapping(path = "/addLesson", method = RequestMethod.POST)

	public R save(Lesson s) {
		R r = null;
		try{
			lessonService.save(s);
			r = new R(true, "保存成功", null);
		}catch(Exception e){
			r = new R(false, "保存失败", null);
		}
		
		return r;
	}

	@RequestMapping(path = "/updateLesson", method = RequestMethod.POST)

	public R update(Lesson s) {
		R r = null;
		try{
			lessonService.update(s);
			r = new R(true, "修改成功", null);
		}catch(Exception e){
			r = new R(false, "保存失败", null);
		}
		
		return r;
	}

	@RequestMapping(path = "/findLesson/{id}", method = RequestMethod.GET)

	public R get(@PathVariable int id) {	
		Lesson s = lessonService.findById(id);
		return new R(true, "", s);
	}

	@RequestMapping(path = "/deleteLesson/{id}")

	public R delete(@PathVariable int id) {
		lessonService.delete(id);
		return new R(true, "", null);
	}

	@RequestMapping(path = "/mdeleteLesson/{selid}", method = RequestMethod.POST)
	public R mdelete(@PathVariable String selid) {
		String[] ids = selid.split(",");
		int[] idss = new int[ids.length];
		for (int i = 0; i < ids.length; i++) {
			idss[i] = Integer.parseInt(ids[i]);
		}
		lessonService.mdelete(idss);
		return new R(true, "", null);
	}

}
