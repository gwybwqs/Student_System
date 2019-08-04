package com.hxz.stu.domain.manager;

import com.hxz.common.page.Page;

/**
 * @author
 */
public class Teacher extends Page {
	/** ���� **/
	private Integer tid;
	private String password;
	private String tname;
	private String gender;
	private String lesson;
	private String phone;

	/** ���췽�� **/

	public Teacher() {
	}

	public Teacher(Integer tid, String password,String tname, String gender, String lesson, String phone) {
		this.tid = tid;
		this.password = password;
		this.tname = tname;
		this.gender = gender;
		this.lesson = lesson;
		this.phone = phone;
	}

	public Teacher(int tid, String password) {
		// TODO Auto-generated constructor stub
		this.tid = tid;
		this.password = password;
	}

	/** setters & getters **/

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		Teacher other = (Teacher) obj;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
			return false;
		return true;
	}

}
