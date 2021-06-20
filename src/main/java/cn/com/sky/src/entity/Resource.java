package cn.com.sky.src.entity;

public class Resource implements java.io.Serializable {

	private Integer resourceid;
	private Resourcetype resourcetype;
	private Users users;
	private String resourcename;
	private String filename;
	private Integer sizes;
	private Integer downcount;
	private String instruction;
	private String date;

	public Resource() {
	}

	public Resource(Resourcetype resourcetype, Users users,
			String resourcename, String filename, Integer sizes,
			Integer downcount, String instruction, String date) {
		this.resourcetype = resourcetype;
		this.users = users;
		this.resourcename = resourcename;
		this.filename = filename;
		this.sizes = sizes;
		this.downcount = downcount;
		this.instruction = instruction;
		this.date = date;
	}

	public Integer getResourceid() {
		return this.resourceid;
	}

	public void setResourceid(Integer resourceid) {
		this.resourceid = resourceid;
	}

	public Resourcetype getResourcetype() {
		return this.resourcetype;
	}

	public void setResourcetype(Resourcetype resourcetype) {
		this.resourcetype = resourcetype;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public String getResourcename() {
		return this.resourcename;
	}

	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}

	public Integer getSizes() {
		return this.sizes;
	}

	public void setSizes(Integer sizes) {
		this.sizes = sizes;
	}

	public Integer getDowncount() {
		return this.downcount;
	}

	public void setDowncount(Integer downcount) {
		this.downcount = downcount;
	}

	public String getInstruction() {
		return this.instruction;
	}

	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

}