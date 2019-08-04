package com.hxz.stu.domain.manager;

import com.hxz.common.page.Page;

/**
 * @author
 */
public class Student extends Page {

	private Integer sid;
	private String password;
	private String sname;
	private String gender;
	private int age;
	private String grade;

	/** ���췽�� **/

	public Student() {
	}

	public Student(Integer sid,String password, String sname, String gender, int age, String grade) {

		this.sid = sid;
		this.password = password;
		this.sname = sname;
		this.gender = gender;
		this.age = age;
		this.grade = grade;
	}

	public Student(int sid, String password) {
		// TODO Auto-generated constructor stub
		this.sid = sid;
		this.password = password;
	}

	/** setters & getters **/

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}
	
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
		Student other = (Student) obj;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		return true;
	}

}
