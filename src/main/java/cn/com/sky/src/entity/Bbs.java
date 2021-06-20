package cn.com.sky.src.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Bbs implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Integer bbsid;
	private Users users;
	private String title;
	private String contents;
	private Integer replycount;
	private String date;
	private Set replies = new HashSet();

	public Bbs() {
	}

	public Bbs(Users users, String title, String contents, Integer replycount,
			String date) {
		this.users = users;
		this.title = title;
		this.contents = contents;
		this.replycount = replycount;
		this.date = date;
	}

	public Bbs(Users users, String title, String contents, Integer replycount,
			String date, Set replies) {
		this.users = users;
		this.title = title;
		this.contents = contents;
		this.replycount = replycount;
		this.date = date;
		this.replies = replies;
	}

	public Integer getBbsid() {
		return this.bbsid;
	}

	public void setBbsid(Integer bbsid) {
		this.bbsid = bbsid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Integer getReplycount() {
		return this.replycount;
	}

	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
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

}