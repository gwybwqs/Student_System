package com.hxz.stu.dao.student;

import java.util.List;

import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Lesson;

public interface SelectedLessonMapper {

	List<Lesson> list(int lid);
	
	int count();
	
	Lesson findById(int id);
	
	void delete(Stulesson s);
	
	//void mdelete(Stulesson s);
	
	List<Stulesson> findStulesson(int sid);

	List<Stulesson> findScore(int id);
	
}
