package cn.com.sky.src.entity;


public class Score implements java.io.Serializable {

	private Integer scoreid;
	private Chapter chapter;
	private Users users;
	private Integer grade;
	private String date;


	public Score() {
	}

	public Score(Chapter chapter, Users users, Integer grade, String date) {
		this.chapter = chapter;
		this.users = users;
		this.grade = grade;
		this.date = date;
	}


	public Integer getScoreid() {
		return this.scoreid;
	}

	public void setScoreid(Integer scoreid) {
		this.scoreid = scoreid;
	}

	public Chapter getChapter() {
		return this.chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}