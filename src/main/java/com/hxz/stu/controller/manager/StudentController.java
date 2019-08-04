package com.hxz.stu.controller.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.common.vo.R;
import com.hxz.stu.domain.manager.Student;
import com.hxz.stu.service.manager.StudentService;

@RequestMapping("/stu")
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * 这就是spring mvc里面的处理器 /stu/list 处理器返回String的话，springmvc会将这个返回值当做一个页面的文件名字
	 * 
	 * @return
	 */
	@RequestMapping("/listStu")
	public R list(PageParam params) {
		Page<Student> stus = studentService.list(params);
		return new R(true, "", null, stus.total, stus.rows);
	}

	@RequestMapping(path = "/addStu", method = RequestMethod.POST)
	public R save(Student s) {
		R r = null;
		try{
			studentService.save(s);
			r = new R(true, "保存成功", null);
		}catch(Exception e){
			r = new R(false, "保存失败", null);
		}
		
		return r;
	}

	@RequestMapping(path = "/updateStu", method = RequestMethod.POST)
	public R update(Student s) {
		R r = null;
		try{
			System.out.println(s.getAge());
			studentService.update(s);
			r = new R(true, "修改成功", null);
		}catch(Exception e){
			r = new R(false, "修改失败", null);
		}
		
		return r;
	}

	@RequestMapping("/deleteStu/{sid}")
	public R delete(@PathVariable int sid) {
		studentService.delete(sid);
		return new R(true, "", null);
	}

	// /stu/get/2
	@RequestMapping("/findStu/{sid}")
	public R get(@PathVariable int sid) {
		Student s = studentService.findById(sid);
		
		return new R(true, "", s);
	}

	@RequestMapping(path = "/mdeleteStu", method = RequestMethod.POST)
	public R mdelete(String ids) {
		String[] selids = ids.split(",");
		int[] idss = new int[selids.length];
		for (int i = 0; i < selids.length; i++) {
			idss[i] = Integer.parseInt(selids[i]);
		}
		studentService.mdelete(idss);
		return new R(true, "", null);
	}

}
