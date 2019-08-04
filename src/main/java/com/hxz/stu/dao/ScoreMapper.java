package com.hxz.stu.dao;

import java.util.List;

import com.hxz.common.page.PageParam;
import com.hxz.stu.domain.Stulesson;

public interface ScoreMapper {

	List<Stulesson> list(PageParam args);

	int count();

	void save(Stulesson s);

	void update(Stulesson s);

	Stulesson findById(int id);

	void delete(int id);

	void mdelete(int[] ids);
}
