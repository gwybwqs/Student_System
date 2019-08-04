package com.hxz.stu.service.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.stu.dao.student.SelectLessonMapper;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Lesson;
import com.hxz.stu.domain.manager.Student;

@Service
@Transactional
public class SelectLessonService {

	@Autowired
	private SelectLessonMapper SelectLessonDao;

	public Page<Lesson> list(PageParam params) {
		Page<Lesson> pages = new Page<Lesson>();
		pages.total = SelectLessonDao.count();
		pages.rows = SelectLessonDao.list(params);
		return pages;

	}
	public Lesson findById(int id) {
		return SelectLessonDao.findById(id);

	}

	public void save(Stulesson s) {
		SelectLessonDao.save(s);
	}

	public Student findStudent(int id) {
		return SelectLessonDao.findStudent(id);

	}
	public int findStuScore(Stulesson s) {
		return SelectLessonDao.findStuScore(s);

	}
}
