package com.hxz.stu.service.teacher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.stu.dao.teacher.updateStudentScoreMapper;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Teacher;

@Service
@Transactional
public class updateStudentScoreService {

	@Autowired
	private updateStudentScoreMapper teacherDao;

	public List<Teacher> list(int tid) {
		return teacherDao.list(tid);

	}

	public Teacher findById(int id) {
		return teacherDao.findById(id);

	}

	

	public void update(Teacher s) {
		teacherDao.update(s);
	}

	public List<Stulesson> findStulesson(int tid){
		return teacherDao.findStulesson(tid);
	}
	
	public void updateScore(Stulesson s){
		teacherDao.updateScore(s);
	}
	
	public Stulesson findScore(int sid,int lid){
		Stulesson s = new Stulesson(sid,lid);
		return teacherDao.findScore(s);
	}

	public void deletelesson(int sid, int lid) {
		Stulesson s = new Stulesson(sid,lid);
		teacherDao.delete(s);
	}
}
