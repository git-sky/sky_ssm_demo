package cn.com.sky.src.entity;

public class Reply implements java.io.Serializable {

	private Integer replyid;
	private Users users;
	private Bbs bbs;
	private String contents;
	private String date;

	public Reply() {
	}

	public Reply(Users users, Bbs bbs, String contents, String date) {
		this.users = users;
		this.bbs = bbs;
		this.contents = contents;
		this.date = date;
	}

	public Integer getReplyid() {
		return this.replyid;
	}

	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Bbs getBbs() {
		return this.bbs;
	}

	public void setBbs(Bbs bbs) {
		this.bbs = bbs;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}