package com.hxz.stu.controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.common.vo.R;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Lesson;
import com.hxz.stu.domain.manager.Student;
import com.hxz.stu.service.student.SelectLessonService;

@RequestMapping("/select")
@RestController
public class SelectLessonController {

	@Autowired
	private SelectLessonService selectLessonService;

	/**
	 * 这就是spring mvc里面的处理器 /stu/list 处理器返回String的话，springmvc会将这个返回值当做一个页面的文件名字
	 * 
	 * @return
	 */
	@RequestMapping("/listLesson")
	public R list(PageParam params) {
		Page<Lesson> stus = selectLessonService.list(params);
		return new R(true, "", null, stus.total, stus.rows);
	}

	@RequestMapping(path = "/findLesson/{lid}", method = RequestMethod.GET)

	public R get(@PathVariable int lid) {
		Lesson s = selectLessonService.findById(lid);
		return new R(true, "", s);
	}

	@RequestMapping(path = "/addStulesson", method = RequestMethod.POST)
	public R save(String ids, HttpServletRequest req, HttpServletResponse resp) {
		String s = (String) req.getSession().getAttribute("id");
		int sid = Integer.parseInt(s);
		Student s1 = selectLessonService.findStudent(sid);
		String[] selids = ids.split(",");
		int[] idss = new int[selids.length];
		for (int i = 0; i < selids.length; i++) {
			idss[i] = Integer.parseInt(selids[i]);
		}
		R r =null;
		try{
			for (int i : idss) {
				Stulesson stulesson = new Stulesson(sid,i);
				System.out.println("----------------");
				int len = selectLessonService.findStuScore(stulesson);
				System.out.println(len);
				if(len==0){
					Lesson l = selectLessonService.findById(i);
					Stulesson l1 = new Stulesson(s1.getSid(), s1.getSname(), l.getLid(), l.getLname(),null);
					selectLessonService.save(l1);
				}else{
					r = new R(false, "您已选过该课程，不可重复", null);
					return r;
				}
				
			}
			 r = new R(true, "选课成功", null);
		}catch(Exception e){
			e.printStackTrace();
		}

		return r;
	}

}
