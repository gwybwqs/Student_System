package com.hxz.stu.domain;

import com.hxz.common.page.Page;

/**
 * @author
 */
public class Stulesson extends Page {
	/** ���� **/
	private Integer sid;
	private String sname;
	private Integer lid;
	private String lname;
	private Integer lscore;
	

	public Stulesson() {
	}
	public Stulesson(Integer sid,Integer idss) {
		this.sid = sid;
		this.lid = idss;
	}
		
	public Stulesson(Integer sid, String sname, Integer lid, String lname, Integer lscore) {

		this.sid = sid;
		this.sname = sname;
		this.lid = lid;
		this.lname = lname;
		this.lscore = lscore;
	}
	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
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

	public Integer getLscore() {
		return lscore;
	}

	public void setLscore(Integer lscore) {
		this.lscore = lscore;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stulesson other = (Stulesson) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}

}
