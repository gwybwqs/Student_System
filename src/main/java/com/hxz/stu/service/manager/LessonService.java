package com.hxz.stu.service.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.stu.dao.manager.LessonMapper;
import com.hxz.stu.domain.manager.Lesson;

@Service
@Transactional
public class LessonService {

	@Autowired
	private LessonMapper lessonDao;

	public Page<Lesson> list(PageParam p) {
		Page<Lesson> pages = new Page<Lesson>();
		pages.total = lessonDao.count();
		pages.rows = lessonDao.list(p);
		return pages;

	}

	public Lesson findById(int id) {
		return lessonDao.findById(id);

	}

	public void save(Lesson s) {
		lessonDao.save(s);
	}

	public void update(Lesson s) {
		lessonDao.update(s);
	}

	public void delete(int id) {
		lessonDao.delete(id);
	}

	public void mdelete(int[] ids) {
		lessonDao.mdelete(ids);
	}

}
