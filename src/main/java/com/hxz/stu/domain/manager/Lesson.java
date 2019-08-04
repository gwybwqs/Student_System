package com.hxz.stu.domain.manager;

import com.hxz.common.page.Page;

/**
 * @author
 */
public class Lesson extends Page {
	/** ���� **/
	private Integer lid;
	private String lname;
	private Integer tid;
	private String tname;
	private Integer ltime;
	private Integer lscore;

	/** ���췽�� **/

	public Lesson() {
	}

	public Lesson(Integer lid, String lname, Integer tid, String tname, Integer ltime, Integer lscore) {

		this.lid = lid;
		this.lname = lname;
		this.tid = tid;
		this.tname = tname;
		this.ltime = ltime;
		this.lscore = lscore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lid == null) ? 0 : lid.hashCode());
		return result;
	}

	public Integer getLid() {
		return lid;
	}

	public void setLid(Integer lid) {
		this.lid = lid;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public Integer getLtime() {
		return ltime;
	}

	public void setLtime(Integer ltime) {
		this.ltime = ltime;
	}

	public Integer getLscore() {
		return lscore;
	}

	public void setLscore(Integer lscore) {
		this.lscore = lscore;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		if (lid == null) {
			if (other.lid != null)
				return false;
		} else if (!lid.equals(other.lid))
			return false;
		return true;
	}

}
