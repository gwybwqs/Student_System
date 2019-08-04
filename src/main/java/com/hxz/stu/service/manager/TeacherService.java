package com.hxz.stu.service.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.stu.dao.manager.TeacherMapper;
import com.hxz.stu.domain.manager.Student;
import com.hxz.stu.domain.manager.Teacher;

@Service
@Transactional
public class TeacherService {

	@Autowired
	private TeacherMapper teacherDao;

	public Page<Teacher> list(PageParam p) {
		Page<Teacher> pages = new Page<Teacher>();
		pages.total = teacherDao.count();
		pages.rows = teacherDao.list(p);
		return pages;

	}

	public Teacher findById(int id) {
		return teacherDao.findById(id);

	}

	public void save(Teacher s) {
		teacherDao.save(s);
	}

	public void update(Teacher s) {
		teacherDao.update(s);
	}

	public void delete(int id) {
		teacherDao.delete(id);
	}

	public void mdelete(int[] ids) {
		teacherDao.mdelete(ids);
	}

}
