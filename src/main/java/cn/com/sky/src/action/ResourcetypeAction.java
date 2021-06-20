package cn.com.sky.src.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.interfaces.ResourcetypeService;

import com.opensymphony.xwork2.Action;

import entity.Resourcetype;

public class ResourcetypeAction implements Action {

	ResourcetypeService rts;
	Resourcetype resourcetype = new Resourcetype();

	public ResourcetypeService getRts() {
		return rts;
	}

	public void setRts(ResourcetypeService rts) {
		this.rts = rts;
	}

	public String add() throws Exception {

		String resourcetypename = ServletActionContext.getRequest()
				.getParameter("title");

		Resourcetype resourcetype = new Resourcetype();

		resourcetype.setResourcetypename(resourcetypename);

		rts.addResourcetype(resourcetype);

		return showall();

	}

	public String update() throws Exception {
		String resourcetypeid = ServletActionContext.getRequest().getParameter(
				"resourcetypeid");

		String name = ServletActionContext.getRequest().getParameter("name");

		resourcetype = rts.queryResourcetypeById(Integer
				.parseInt(resourcetypeid));

		resourcetype.setResourcetypename(name);
		rts.updateResourcetype(resourcetype);
		setResourcetype(resourcetype);
		return "json2";
	}

	public Resourcetype getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(Resourcetype resourcetype) {
		this.resourcetype = resourcetype;
	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String delete() throws NumberFormatException, Exception {

		String resourcetypeid = ServletActionContext.getRequest().getParameter(
				"resourcetypeid");

		rts.deleteResourcetype(Integer.parseInt(resourcetypeid));

		return showall();
	}

	public String showall() throws Exception {

		List<Resourcetype> all = rts.queryAllResourcetype();

		ServletActionContext.getRequest().setAttribute("all", all);

		return SUCCESS;

	}

}
