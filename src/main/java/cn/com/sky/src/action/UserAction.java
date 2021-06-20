package cn.com.sky.src.action;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import org.apache.struts2.ServletActionContext;
import service.interfaces.UsersService;
import entity.Users;

public class UserAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private UsersService us;

	public void setUs(UsersService us) {
		this.us = us;
	}

	private Users user = new Users();

	public Users getModel() {
		return user;
	}

	public String check() throws Exception {

		if (null != us.queryUserByName(ServletActionContext.getRequest()
				.getParameter("username"))) {

			return "aa";
		}
		return "useful";
	}

	public String add() throws Exception {

		if (us.checkUser(user)) {
			return "error";

		} else {
			user.setDate(sdf.format(new Date()));

			us.addUser(user);
			return "insert";
		}
	}

	public String updatesubmit() throws Exception {

		// user.setDate(user.getDate());
		us.updateUser(user);

		if (null == ServletActionContext.getRequest().getSession()
				.getAttribute("user")) {
			return showall();
		} else {
			return "updateok";
		}
	}

	public String update() {

		int userid;
		if (null != ServletActionContext.getRequest().getParameter("userid")) {
			userid = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("userid"));
		} else {
			userid = ((Users) ServletActionContext.getRequest().getSession()
					.getAttribute("user")).getUserid();
		}

		Users user = us.queryUserById(userid);

		ServletActionContext.getRequest().setAttribute("user", user);

		// 得到所修改的数据所在的页码
		String page = ServletActionContext.getRequest().getParameter("page");
		ServletActionContext.getRequest().setAttribute("page", page);
		return "update";
	}

	public String delete() throws Exception {
		String userid = ServletActionContext.getRequest()
				.getParameter("userid");

		us.deleteUser(Integer.parseInt(userid));

		return showall();

	}

	@SuppressWarnings("unchecked")
	public String show() throws NumberFormatException, Exception {

		String userid = ServletActionContext.getRequest()
				.getParameter("userid");

		Map m = us.show(Integer.parseInt(userid));

		ServletActionContext.getRequest().setAttribute("bbs", m.get("bbs"));

		ServletActionContext.getRequest().setAttribute("score", m.get("score"));
		ServletActionContext.getRequest().setAttribute("resource",
				m.get("resource"));

		return "show";
	}

	public String showall() throws Exception {

		String username = ServletActionContext.getRequest()
				.getParameter("name");

		ServletActionContext.getRequest().setAttribute("name", username);

		if (null != username && username.isEmpty() == false) {
			// 查询指定的用户
			Users user = us.queryUserByName(username);

			String hql = "from Users user where user.roles.roleid=1 and user.username='"
					+ username + "'";

			// 查询指定的用户,只有一页，并且是第一页
			totalCount = us.getTotalCount(hql);
			totalPage = ((totalCount + pageSize) - 1) / pageSize;
			// totalPage不能小于1;
			if (totalPage == 0) {
				totalPage = 1;
			}
			curPage = 1;

			ServletActionContext.getRequest().setAttribute("all", user);

			return SUCCESS;
		} else {
			// 查询所有的用户
			String hql = "from Users users where users.roles.roleid=1 order by date desc";
			// 查询用户的数量
			totalCount = us.getTotalCount(hql);
			// 共多少页
			totalPage = ((totalCount + pageSize) - 1) / pageSize;
			// 如果没有用户，totalPage赋值为1；
			if (totalPage == 0) {
				totalPage = 1;
			}

			// 请求的页数
			String pageString = ServletActionContext.getRequest().getParameter(
					"page");

			if (null == pageString || pageString.length() == 0) {
				// 没有请求页码的时候，当前页是第一页。
				curPage = 1;
			} else if (null != pageString && pageString.length() != 0) {
				try {
					// 请求的页码
					curPage = Integer.parseInt(pageString);

					// 如果当前页大于总页数，则当前页赋值为总页数
					if (curPage > totalPage)
						curPage = totalPage;

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			List<Users> all = us.queryAllUser(hql, curPage, pageSize);

			ServletActionContext.getRequest().setAttribute("all", all);

			return SUCCESS;

		}
	}
}
