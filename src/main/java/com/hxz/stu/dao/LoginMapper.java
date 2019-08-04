package com.hxz.stu.dao;

import com.hxz.stu.domain.User;
import com.hxz.stu.domain.manager.Student;
import com.hxz.stu.domain.manager.Teacher;

public interface LoginMapper {

	int ManagerCheck(User s);

	int TeacherCheck(Teacher s);

	int StudentCheck(Student s);
	
	Student findStudent(int sid);
	
	Teacher findTeacher(int tid);
}
