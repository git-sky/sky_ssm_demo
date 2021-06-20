package cn.com.sky.src.entity;

import java.util.HashSet;
import java.util.Set;

public class Resourcetype implements java.io.Serializable {

	private Integer resourcetypeid;
	private String resourcetypename;
	private Set resources = new HashSet();

	public String getResourcetypename() {
		return resourcetypename;
	}

	public void setResourcetypename(String resourcetypename) {
		this.resourcetypename = resourcetypename;
	}

	public Resourcetype() {
	}

	public Resourcetype(String resourcetypename) {
		this.resourcetypename = resourcetypename;
	}

	public Resourcetype(String resourcetypename, Set resources) {
		this.resourcetypename = resourcetypename;
		this.resources = resources;
	}

	public Integer getResourcetypeid() {
		return this.resourcetypeid;
	}

	public void setResourcetypeid(Integer resourcetypeid) {
		this.resourcetypeid = resourcetypeid;
	}

	public Set getResources() {
		return this.resources;
	}

	public void setResources(Set resources) {
		this.resources = resources;
	}

}