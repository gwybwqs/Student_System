package com.hxz.stu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hxz.common.page.Page;
import com.hxz.common.page.PageParam;
import com.hxz.stu.dao.ScoreMapper;
import com.hxz.stu.domain.Stulesson;
import com.hxz.stu.domain.manager.Lesson;

@Service
@Transactional
public class ScoreService {

	@Autowired
	private ScoreMapper soreDao;

	public Page<Stulesson> list(PageParam p) {
		Page<Stulesson> pages = new Page<Stulesson>();
		pages.total = soreDao.count();
		pages.rows = soreDao.list(p);
		return pages;

	}

	public Stulesson findById(int id) {
		return soreDao.findById(id);

	}

	public void save(Stulesson s) {
		soreDao.save(s);
	}

	public void update(Stulesson s) {
		soreDao.update(s);
	}

	public void delete(int id) {
		soreDao.delete(id);
	}

	public void mdelete(int[] ids) {
		soreDao.mdelete(ids);
	}

}
