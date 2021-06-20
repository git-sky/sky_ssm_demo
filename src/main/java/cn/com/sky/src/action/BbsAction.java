package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.interfaces.BbsService;
import entity.Bbs;
import entity.Reply;
import entity.Users;

public class BbsAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	// 模型驱动
	Bbs bbs = new Bbs();

	// 注入依赖
	private BbsService bs;

	public void setBs(BbsService bs) {
		this.bs = bs;
	}

	public String add() {

		Users user = null;

		// 如果是游客则不能发表留言
		if (null == ServletActionContext.getRequest().getSession()
				.getAttribute("user")
				&& null == ServletActionContext.getRequest().getSession()
						.getAttribute("admin")) {
			return LOGIN;
		}

		if (null != ServletActionContext.getRequest().getSession()
				.getAttribute("user")) {
			// 普通用户
			user = (Users) ServletActionContext.getRequest().getSession()
					.getAttribute("user");
		} else if (null != ServletActionContext.getRequest().getSession()
				.getAttribute("admin")) {
			// 管理员
			user = (Users) ServletActionContext.getRequest().getSession()
					.getAttribute("admin");
		}

		Users usr = new Users();

		usr.setUserid(user.getUserid());

		bbs.setUsers(usr);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String date = sdf.format(new Date());
		bbs.setDate(date);

		bs.addBbs(bbs);
		
		if(null != ServletActionContext.getRequest().getSession()
				.getAttribute("admin")){
			return "insert";
		}

		return "showall";
	}

	public String delete() {

		int flag = 0;

		if (null != ServletActionContext.getRequest().getParameter("flag")) {

			flag = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("flag"));

		}

		String bbsid = ServletActionContext.getRequest().getParameter("bbsid");

		bs.deleteBbs(Integer.parseInt(bbsid));

		if (flag == 2) {
			return showuser();
		} else {
			return showall();
		}

	}

	public String showsome() {
		String hql = "from Bbs order by date desc";
		List<Bbs> some = bs.queryAllBbs(hql, 1, 5);
		ServletActionContext.getRequest().setAttribute("bbs", some);
		return "some";
	}

	// 管理员查看用户的bbs主题
	public String showuser() {
		int userid = 0;
		if (null != ServletActionContext.getRequest().getParameter("userid")) {
			userid = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("userid"));
		}

		// 把标志放入request中
		ServletActionContext.getRequest().setAttribute("userid", userid);

		String hql = "from Bbs bbs where bbs.users.userid='" + userid + "' ";

		totalCount = bs.getTotalCount(hql);
		totalPage = ((totalCount + pageSize) - 1) / pageSize;
		if (totalPage == 0) {
			totalPage = 1;
		}

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

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

		List<Bbs> bbs = bs.queryAllBbs(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("bbs", bbs);

		return "showuser";
	}

	// 用户查看自己的bbs主题
	public String showmy() {

		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user");
		int id = user.getUserid();

		String hql = "from Bbs bbs where bbs.users.userid='" + id + "'";

		totalCount = bs.getTotalCount(hql);

		totalPage = ((totalCount + pageSize) - 1) / pageSize;

		if (totalPage == 0) {
			totalPage = 1;
		}
		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		if (pageString == null || pageString.length() == 0) {
			curPage = 1;
		} else {
			try {
				curPage = Integer.parseInt(pageString);
				if (curPage > totalPage)
					curPage = totalPage;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		List<Bbs> bbs = bs.queryAllBbs(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("bbs", bbs);

		return "showuser";
	}

	public String show() {

		int flag = 0;

		if (null != ServletActionContext.getRequest().getParameter("flag")) {

			flag = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("flag"));

		}

		int bbsid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("bbsid"));

		Bbs bbs = bs.queryBbsById(bbsid);

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		if (null != pageString) {
			ServletActionContext.getRequest().setAttribute("page", pageString);
		}

		String hql = "from Reply reply where reply.bbs.bbsid='" + bbsid + "' ";

		totalCount = bs.getTotalCount(hql);
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

		List<Reply> reply = bs.queryAllReply(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("bbs", bbs);

		ServletActionContext.getRequest().setAttribute("all", reply);

		if (flag == 2) {
			return "show";
		} else {
			return "show2";

		}

	}

	public String showall() {

		String title = ServletActionContext.getRequest().getParameter(
				"bbstitle");

		if (null != title) {
			ServletActionContext.getRequest().getSession().setAttribute(
					"title", title);
		}

		String condition = ServletActionContext.getRequest().getParameter(
				"condition");

		if (condition != null) {
			// 条件查询
			if (condition.equals("select2")) {

				if (null == title) {
					ServletActionContext.getRequest().getSession()
							.setAttribute("title", "");
				}

				// 查询所有的数据
				ServletActionContext.getRequest().getSession().setAttribute(
						"condition",
						"from Bbs bbs where bbs.title like '%" + title + "%' ");

			} else {
				// 直接从manage.jsp查询

				ServletActionContext.getRequest().getSession().setAttribute(
						"condition", "from Bbs order by date desc");
				ServletActionContext.getRequest().getSession().setAttribute(
						"title", "");
			}
		}
		
		if (null == title) {
			ServletActionContext.getRequest().getSession()
					.setAttribute("title", "");
		}
		if(null==condition){
			ServletActionContext.getRequest().getSession().setAttribute(
					"condition", "from Bbs order by date desc");
		}

		String hql = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("condition");

		totalCount = bs.getTotalCount(hql);
		totalPage = ((totalCount + pageSize) - 1) / pageSize;
		if (totalPage == 0) {
			totalPage = 1;
		}

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

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

		List<Bbs> all = bs.queryAllBbs(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("all", all);

		return SUCCESS;
	}

	public Bbs getModel() {
		return bbs;
	}

}
