package cn.com.sky.src.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.interfaces.ArticletypeService;

import com.opensymphony.xwork2.Action;

import entity.Articletype;

public class ArticletypeAction implements Action {

	ArticletypeService ats;

	public ArticletypeService getAts() {
		return ats;
	}

	public void setAts(ArticletypeService ats) {
		this.ats = ats;
	}

	Articletype articletype = new Articletype();

	public Articletype getArticletype() {
		return articletype;
	}

	public void setArticletype(Articletype articletype) {
		this.articletype = articletype;
	}

	public String add() throws Exception {

		String title = ServletActionContext.getRequest().getParameter("title");

		Articletype articletype = new Articletype();

		articletype.setName(title);

		ats.addArticletype(articletype);

		return showall();

	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String update() throws Exception {
		String articletypeid = ServletActionContext.getRequest().getParameter(
				"articletypeid");

		String name = ServletActionContext.getRequest().getParameter("name");

		articletype = ats.queryArticletypeByID(Integer.parseInt(articletypeid));

		articletype.setName(name);
		ats.updateArticletype(articletype);

		setArticletype(articletype);

		return "json2";
	}

	public String delete() throws NumberFormatException, Exception {

		String articletypeid = ServletActionContext.getRequest().getParameter(
				"articletypeid");

		ats.deleteArticletype(Integer.parseInt(articletypeid));

		return showall();
	}

	public String showall() throws Exception {

		List<Articletype> all = ats.queryAllArticletype();

		ServletActionContext.getRequest().setAttribute("all", all);

		return SUCCESS;

	}

	public String getName() {
		return articletype.getName();
	}
}
