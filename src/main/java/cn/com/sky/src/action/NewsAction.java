package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.interfaces.NewsService;
import entity.News;

public class NewsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private NewsService ns;

	private String title;
	private int readcount;
	private String source;
	private String contents;

	News news = new News();

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void setNs(NewsService ns) {
		this.ns = ns;
	}

	public String add() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		news.setDate(date);
		ns.addNews(news);
		return "insert";
	}

	public String updatesubmit() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		news.setDate(date);
		ns.updateNews(news);
		return showall();
	}

	public String update() {

		String newsid = ServletActionContext.getRequest()
				.getParameter("newsid");

		String page = ServletActionContext.getRequest().getParameter("page");

		ServletActionContext.getRequest().setAttribute("page", page);

		News news = ns.queryNewsById(Integer.parseInt(newsid));

		ServletActionContext.getRequest().setAttribute("news", news);

		return "update";

	}

	public String delete() {
		String newsid = ServletActionContext.getRequest()
				.getParameter("newsid");
		ns.deleteNews(Integer.parseInt(newsid));
		return showall();

	}

	public String show() {
		String newsid = ServletActionContext.getRequest()
				.getParameter("newsid");

		News news = ns.queryNewsById(Integer.parseInt(newsid));

		news.setReadcount(news.getReadcount() + 1);

		ns.updateNews(news);

		ServletActionContext.getRequest().setAttribute("news", news);

		return "show";
	}

	public String showsome() {
		String hql = "from News order by date desc";
		List<News> some = ns.queryAllNews(hql, 1, 5);
		ServletActionContext.getRequest().setAttribute("news", some);
		return "some";
	}

	public String showall() {

		// 新闻标题
		String title = ServletActionContext.getRequest().getParameter(
				"newstitle");
		if (null != title) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"title", title);
		}
		// 新闻来源
		String source = ServletActionContext.getRequest().getParameter(
				"newssource");

		if (null != source) {

			ServletActionContext.getRequest().getSession().setAttribute(
					"source", source);
		}

		// 条件查询
		String condition = ServletActionContext.getRequest().getParameter(
				"condition");

		if (condition != null) {
			// 条件查询
			if (condition.equals("select2")) {

				if (null == title) {
					ServletActionContext.getRequest().getSession()
							.setAttribute("title", "");
				}

				if (null == source) {
					ServletActionContext.getRequest().getSession()
							.setAttribute("source", "");
				}
				// 查询所有的数据
				ServletActionContext.getRequest().getSession().setAttribute(
						"condition",
						"from News news where news.title like '%" + title
								+ "%' and news.source like '%" + source + "%'");

			} else {
				// 直接从manage.jsp查询

				ServletActionContext.getRequest().getSession().setAttribute(
						"condition", "from News order by date desc");
				ServletActionContext.getRequest().getSession().setAttribute(
						"title", "");
				ServletActionContext.getRequest().getSession().setAttribute(
						"source", "");
			}
		}

		String hql = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("condition");

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		totalCount = ns.getTotalCount(hql);

		totalPage = ((totalCount + pageSize) - 1) / pageSize;
		if (totalPage == 0) {
			totalPage = 1;
		}

		if (pageString == null || pageString.length() == 0) {
			curPage = 1;
		} else if (null != pageString && pageString.length() != 0) {
			try {
				curPage = Integer.parseInt(pageString);
				if (curPage > totalPage)
					curPage = totalPage;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		List<News> all = ns.queryAllNews(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("all", all);

		return SUCCESS;
	}

	@Override
	public News getModel() {
		return news;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	public int getReadcount() {
		return readcount;
	}
}
