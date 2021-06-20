package cn.com.sky.src.action;

import org.apache.struts2.ServletActionContext;

import model.CountWeb;
import service.interfaces.*;

public class WebCountAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private ArticleService article;
	private UsersService users;
	private BbsService bbs;
	private NewsService news;
	private ResourceService resource;
	private TestbankService testbank;

	public String showall() {

		CountWeb cw = new CountWeb();

		int articleCount = article.getTotalCount("from Article");

		int bbsCount = bbs.getTotalCount("from Bbs");

		int newsCount = news.getTotalCount("from News");

		int resourceCount = resource.getTotalCount("from Resource");
		int testbankCount = testbank.getTotalCount("from Testbank");

		int usersCount = users.getTotalCount("from Users");

		cw.setArticleCount(articleCount);
		cw.setBbsCount(bbsCount);
		cw.setUsersCount(usersCount);
		cw.setNewsCount(newsCount);
		cw.setResourceCount(resourceCount);
		cw.setTestbankCount(testbankCount);

		ServletActionContext.getRequest().setAttribute("cw", cw);

		return SUCCESS;

	}

	public String show() {

		CountWeb cw = new CountWeb();
		
		int articleCount = article.getTotalCount("from Article");
		int bbsCount = bbs.getTotalCount("from Bbs");
		int newsCount = news.getTotalCount("from News");
		int resourceCount = resource.getTotalCount("from Resource");
		int testbankCount = testbank.getTotalCount("from Testbank");

		cw.setArticleCount(articleCount);
		cw.setBbsCount(bbsCount);
		cw.setNewsCount(newsCount);
		cw.setResourceCount(resourceCount);
		cw.setTestbankCount(testbankCount);

		ServletActionContext.getRequest().setAttribute("cw", cw);

		return "some";

	}

	public UsersService getUsers() {
		return users;
	}

	public void setUsers(UsersService users) {
		this.users = users;
	}

	public BbsService getBbs() {
		return bbs;
	}

	public void setBbs(BbsService bbs) {
		this.bbs = bbs;
	}

	public NewsService getNews() {
		return news;
	}

	public void setNews(NewsService news) {
		this.news = news;
	}

	public ResourceService getResource() {
		return resource;
	}

	public void setResource(ResourceService resource) {
		this.resource = resource;
	}

	public TestbankService getTestbank() {
		return testbank;
	}

	public void setTestbank(TestbankService testbank) {
		this.testbank = testbank;
	}

	public void setArticle(ArticleService article) {
		this.article = article;
	}

	public ArticleService getArticle() {
		return article;
	}

}
