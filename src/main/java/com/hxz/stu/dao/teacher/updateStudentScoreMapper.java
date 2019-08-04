package com.hxz.stu.dao.teacher;

import java.util.List;

import com.hxz.common.page.PageParam;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Teacher;

public interface updateStudentScoreMapper {

	List<Teacher> list(int id);

	void update(Teacher s);

	Teacher findById(int id);
	
	List<Stulesson> findStulesson(int tid);

	
	void updateScore(Stulesson s);
	
	Stulesson findScore(Stulesson s);

	void delete(Stulesson s);
}
