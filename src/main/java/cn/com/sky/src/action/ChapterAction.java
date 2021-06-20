package cn.com.sky.src.action;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;
import entity.Chapter;
import service.interfaces.ChapterService;
import java.util.List;

public class ChapterAction implements Action {
	private ChapterService cs;

	Chapter chapter = new Chapter();

	List<Chapter> alltype;

	public List<Chapter> getAlltype() {
		return alltype;
	}

	public void setAlltype(List<Chapter> alltype) {
		this.alltype = alltype;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public void setCs(ChapterService cs) {
		this.cs = cs;
	}

	public ChapterService getCs() {
		return cs;
	}

	public String add() throws Exception {

		String title = ServletActionContext.getRequest().getParameter("title");

		Chapter chapter = new Chapter();

		chapter.setName(title);

		cs.addChapter(chapter);

		return showall();

	}

	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}

	public String update() throws Exception {
		String chapterid = ServletActionContext.getRequest().getParameter(
				"chapterid");

		String name = ServletActionContext.getRequest().getParameter("name");

		chapter = cs.queryChapterById(Integer.parseInt(chapterid));

		chapter.setName(name);
		cs.updateChapter(chapter);
		setChapter(chapter);

		return "json2";
	}

	public String delete() throws NumberFormatException, Exception {

		String chapterid = ServletActionContext.getRequest().getParameter(
				"chapterid");

		cs.deleteChapter(Integer.parseInt(chapterid));

		return showall();
	}

	public String showall() throws Exception {

		if (null == ServletActionContext.getRequest().getSession()
				.getAttribute("user")
				&& null == ServletActionContext.getRequest().getSession()
						.getAttribute("admin")) {
			return "login";
		}
		alltype = cs.queryAllChapter();
		setAlltype(alltype);

		ServletActionContext.getRequest().setAttribute("all", alltype);

		return "showall";

	}

}
