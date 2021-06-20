package cn.com.sky.src.entity;

import java.util.HashSet;
import java.util.Set;

public class Roles implements java.io.Serializable {

	private Integer roleid;
	private String rolename;
	private Set userses = new HashSet();

	public Roles() {
	}

	public Roles(String rolename) {
		this.rolename = rolename;
	}

	public Roles(String rolename, Set userses) {
		this.rolename = rolename;
		this.userses = userses;
	}

	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set getUserses() {
		return this.userses;
	}

	public void setUserses(Set userses) {
		this.userses = userses;
	}

}