package com.hxz.stu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.stu.dao.LoginMapper;
import com.hxz.stu.domain.User;
import com.hxz.stu.domain.manager.Student;
import com.hxz.stu.domain.manager.Teacher;

@Service
@Transactional
public class LoginService {
	@Autowired
	private LoginMapper loginDao;

	public boolean ManagerCheck(User s) {
		if (loginDao.ManagerCheck(s) == 1) {
			return true;
		}

		return false;

	}

	public boolean TeacherCheck(Teacher s) {
		// TODO Auto-generated method stub
		if (loginDao.TeacherCheck(s) == 1) {
			return true;
		}

		return false;
	}

	public boolean studentCheck(Student s) {
		if (loginDao.StudentCheck(s) == 1) {
			return true;
		}

		return false;
	}
	
	
	public Student findStudent(int id) {
		return loginDao.findStudent(id);

	}
	
	
	public Teacher findTeacher(int id) {
		return loginDao.findTeacher(id);
	}
	
}
