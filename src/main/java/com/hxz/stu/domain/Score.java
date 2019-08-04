package com.hxz.stu.domain;

/**
 * @author 
 */
public class Score {
	/**  ����  **/
	private Integer id;
	private String name;
	private Integer lesson1;
	private Integer lesson2;
	private Integer lesson3;

	/**  ���췽�� **/
	
	public Score() {}

	public Score(Integer id, String name, Integer lesson1, Integer lesson2,Integer lesson3) {
		this.id = id;
		this.name = name;
		this.lesson1 = lesson1;
		this.lesson2 = lesson2;
		this.lesson3 = lesson3;
	}
	
	/** setters & getters **/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getLesson1() {
		return lesson1;
	}

	public void setLesson1(Integer lesson1) {
		this.lesson1 = lesson1;
	}

	public Integer getLesson2() {
		return lesson2;
	}

	public void setLesson2(Integer lesson2) {
		this.lesson2 = lesson2;
	}

	public Integer getLesson3() {
		return lesson3;
	}

	public void setLesson3(Integer lesson3) {
		this.lesson3 = lesson3;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Score other = (Score) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
