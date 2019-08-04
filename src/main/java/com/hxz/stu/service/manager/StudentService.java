package com.hxz.stu.service.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.stu.dao.manager.StudentMapper;
import com.hxz.stu.domain.manager.Student;

@Service
@Transactional
public class StudentService {

	@Autowired
	private StudentMapper studentDao;

	public Page<Student> list(PageParam params) {
		Page<Student> pages = new Page<Student>();
		pages.total = studentDao.count();
		pages.rows = studentDao.list(params);
		return pages;

	}

	public Student findById(int id) {
		return studentDao.findById(id);

	}

	public void save(Student s) {
		studentDao.save(s);
	}

	public void update(Student s) {
		studentDao.update(s);
	}

	public void delete(int id) {
		studentDao.delete(id);
	}

	public void mdelete(int[] ids) {
		studentDao.mdelete(ids);
	}

}
