package com.hxz.stu.dao.manager;

import java.util.List;

import com.hxz.common.page.PageParam;
import com.hxz.stu.domain.manager.Lesson;

public interface LessonMapper {

	List<Lesson> list(PageParam args);

	int count();

	void save(Lesson s);

	void update(Lesson s);

	Lesson findById(int id);

	void delete(int id);

	void mdelete(int[] ids);
}
