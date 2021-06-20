package cn.com.sky.src.entity;

import java.util.HashSet;
import java.util.Set;

public class Users implements java.io.Serializable {

	private Integer userid;
	private Roles roles;
	private String username;
	private String pass;
	private String sex;
	private String question;
	private String answer;
	private String email;
	private String qq;
	private String date;

	private Set replies = new HashSet();
	private Set bbses = new HashSet();
	private Set resources = new HashSet();
	private Set scores = new HashSet();

	public Users(Integer userid, Roles roles, String username, String pass,
			String sex, String quesiton, String answer, String email,
			String mark, String qq, String date, Set replies, Set bbses,
			Set resources, Set scores) {
		this.roles = roles;
		this.username = username;
		this.pass = pass;
		this.sex = sex;
		this.question = quesiton;
		this.answer = answer;
		this.email = email;
		this.qq = qq;
		this.date = date;
		this.replies = replies;
		this.bbses = bbses;
		this.resources = resources;
		this.scores = scores;
	}

	public Users() {
	}

	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return this.pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Set getReplies() {
		return this.replies;
	}

	public void setReplies(Set replies) {
		this.replies = replies;
	}

	public Set getBbses() {
		return this.bbses;
	}

	public void setBbses(Set bbses) {
		this.bbses = bbses;
	}

	public Set getResources() {
		return this.resources;
	}

	public void setResources(Set resources) {
		this.resources = resources;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

}