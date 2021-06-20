package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.interfaces.ArticleService;
import service.interfaces.ArticletypeService;
import entity.Article;
import entity.Articletype;

public class ArticleAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	// 通过注入依赖，得到ArticleService
	private ArticleService as;

	// 模型驱动，接受客户端传过来的数据。
	Article article = new Article();

	// 通过注入依赖，得到ArticletypeService
	private ArticletypeService ats;

	// 条件
	List<?> cond;

	// 所有的文章类型
	List alltype;

	public List getAlltype() {
		return alltype;
	}

	public void setAlltype(List alltype) {
		this.alltype = alltype;
	}

	public void setAts(ArticletypeService ats) {
		this.ats = ats;
	}

	public String add() {
		String a = ServletActionContext.getRequest().getParameter("a");
		if (a == null) {
			try {

				alltype = ats.queryAllArticletype();
				setAlltype(alltype);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "add";
		} else {

			String articletypeid = ServletActionContext.getRequest()
					.getParameter("articletypeid");

			Articletype at = new Articletype();

			at.setArticletypeid(Integer.parseInt(articletypeid));

			article.setArticletype(at);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			String date = sdf.format(new Date());

			article.setDate(date);

			as.addArticle(article);

			return "insert";
		}

	}

	// 显示文章
	public String show() throws Exception {

		String articleid = ServletActionContext.getRequest().getParameter(
				"articleid");
		Article article = as.queryArticleById(Integer.parseInt(articleid));

		article.setReadcount(article.getReadcount() + 1);

		as.updateArticle(article);

		ServletActionContext.getRequest().setAttribute("article", article);
		return "show";
	}

	// 文章信息的修改
	public String update() {

		String articleid = ServletActionContext.getRequest().getParameter(
				"articleid");

		String articletypeid = ServletActionContext.getRequest().getParameter(
				"articletypeid");
		// 取得文章的类型数目
		alltype = ats.queryAllArticletype();
		setAlltype(alltype);
		// 得到该文章
		Article article = as.queryArticleById(Integer.parseInt(articleid));

		Articletype articletype = ats.queryArticletypeByID(Integer
				.parseInt(articletypeid));

		// 得到所修改的数据所在的页码
		String page = ServletActionContext.getRequest().getParameter("page");

		ServletActionContext.getRequest().setAttribute("page", page);

		ServletActionContext.getRequest().setAttribute("article", article);

		ServletActionContext.getRequest().setAttribute("articletype",
				articletype);

		return "update";
	}

	// 文章信息的提交修改
	public String updatesubmit() throws Exception {

		int articletypeid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("articletypeid2"));

		Articletype articletype = new Articletype();

		articletype.setArticletypeid(articletypeid);

		article.setArticletype(articletype);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String date = sdf.format(new Date());
		article.setDate(date);

		as.updateArticle(article);

		return showall();

	}

	// 文章的删除
	public String delete() {
		try {
			String articleid = ServletActionContext.getRequest().getParameter(
					"articleid");
			as.deleteArticle(Integer.parseInt(articleid));

			return showall();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;

	}

	public String showall() throws Exception {
		// 查出所有的文章类型
		alltype = ats.queryAllArticletype();
		setAlltype(alltype);

		// 得到传来的文章名称
		String title = ServletActionContext.getRequest().getParameter(
				"articletitle");

		if (null != title) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"title", title);
		}

		// 得到传来的 文章类型
		String articletypeid = ServletActionContext.getRequest().getParameter(
				"articletypeid");

		if (null != articletypeid) {
			Articletype articletype = ats.queryArticletypeByID(Integer
					.parseInt(articletypeid));

			ServletActionContext.getRequest().getSession().setAttribute(
					"articletype", articletype);
		}

		// 条件查询
		String condition = ServletActionContext.getRequest().getParameter(
				"condition");

		if (condition != null) {
			// 条件查询
			if (null != title && null != articletypeid) {

				if (null == title) {
					ServletActionContext.getRequest().getSession()
							.setAttribute("title", "");
				}

				// 查询所有的数据
				if (Integer.parseInt(articletypeid) == 0) {
					ServletActionContext.getRequest().getSession()
							.setAttribute(
									"condition",
									"from Article article where article.title like '%"
											+ title + "%' order by date desc");
				} else {
					// 按条件查询
					ServletActionContext
							.getRequest()
							.getSession()
							.setAttribute(
									"condition",
									"from Article article where article.title like '%"
											+ title
											+ "%' and article.articletype.articletypeid = '"
											+ articletypeid
											+ "' order by date desc");

				}

			} else {

				ServletActionContext.getRequest().getSession().removeAttribute(
						"condition");
				ServletActionContext.getRequest().getSession().removeAttribute(
						"title");
				ServletActionContext.getRequest().getSession().removeAttribute(
						"articletype");

				// 直接从manage.jsp查询
				ServletActionContext.getRequest().getSession().setAttribute(
						"condition", "from Article order by date desc");
				ServletActionContext.getRequest().getSession().setAttribute(
						"title", "");
			}
		}

		String hql = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("condition");

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		totalCount = as.getTotalCount(hql);

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

		List<Article> all = as.queryAllArticle(hql, curPage, pageSize);

		// 放入查询出的article
		ServletActionContext.getRequest().setAttribute("all", all);

		return SUCCESS;

	}

	public String showsome() {
		String hql = "from Article order by date desc";
		List<Article> some = as.queryAllArticle(hql, 1, 5);
		ServletActionContext.getRequest().setAttribute("article", some);
		return "some";
	}

	@Override
	public Article getModel() {
		return article;
	}

	public void setAs(ArticleService as) {
		this.as = as;
	}
}
