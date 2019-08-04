package com.hxz.stu.dao.manager;

import java.util.List;

import com.hxz.common.page.PageParam;
import com.hxz.stu.domain.manager.Student;

public interface StudentMapper {

	List<Student> list(PageParam args);

	int count();

	void save(Student s);

	void update(Student s);

	Student findById(int id);

	void delete(int id);

	void mdelete(int[] sid);
}
