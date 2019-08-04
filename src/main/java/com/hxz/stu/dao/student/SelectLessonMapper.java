package com.hxz.stu.dao.student;

import java.util.List;

import com.hxz.common.page.PageParam;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Lesson;
import com.hxz.stu.domain.manager.Student;

public interface SelectLessonMapper {

	List<Lesson> list(PageParam args);
	
	int count();
	
	Lesson findById(int id);
	
	void mselect(int[] sid);
	
	Student findStudent(int sid);
	
	void save(Stulesson s);
	
	int findStuScore(Stulesson s);
}
