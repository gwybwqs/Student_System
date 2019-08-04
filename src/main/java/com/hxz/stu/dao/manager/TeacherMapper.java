package com.hxz.stu.dao.manager;

import java.util.List;

import com.hxz.common.page.PageParam;
import com.hxz.stu.domain.manager.Teacher;

public interface TeacherMapper {

	List<Teacher> list(PageParam args);

	int count();

	void save(Teacher s);

	void update(Teacher s);

	Teacher findById(int id);

	void delete(int id);

	void mdelete(int[] ids);
}
