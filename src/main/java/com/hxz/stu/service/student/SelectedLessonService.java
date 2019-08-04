package com.hxz.stu.service.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.common.page.Page;
import com.hxz.stu.dao.student.SelectedLessonMapper;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Lesson;

@Service
@Transactional
public class SelectedLessonService {

	@Autowired
	private SelectedLessonMapper SelectedLessonDao;

	public List<Lesson> list(int lid) {
		Page<Lesson> pages = new Page<Lesson>();
		pages.total = SelectedLessonDao.count();
		//pages.rows = SelectedLessonDao.list(p);
		return SelectedLessonDao.list(lid);

	}
	public Lesson findById(int id) {
		return SelectedLessonDao.findById(id);

	}

	

	public List<Stulesson> findStulesson(int sid){
		
		return SelectedLessonDao.findStulesson(sid);
		
	}
	public void delete(int sid,int lid) {
		Stulesson s = new Stulesson(sid,lid);
		SelectedLessonDao.delete(s);
		
	}
	public void mdelete(int sid,int[] idss) {
		for(int lid:idss){
			Stulesson s = new Stulesson(sid,lid);
			SelectedLessonDao.delete(s);
		}
		
	}
	public List<Stulesson> findScore(int id) {
		// TODO Auto-generated method stub
		return SelectedLessonDao.findScore(id);
	}
}
