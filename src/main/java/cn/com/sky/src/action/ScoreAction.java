package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import service.interfaces.ScoreService;
import entity.Score;
import entity.Users;

public class ScoreAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	private ScoreService ss;

	public void setSs(ScoreService ss) {
		this.ss = ss;
	}

	public ScoreService getSs() {
		return ss;
	}

	public String add() {

		Score score = new Score();

		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user");

		Users usr = new Users();

		usr.setUserid(user.getUserid());

		score.setUsers(usr);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String date = sdf.format(new Date());
		score.setDate(date);
		ss.addScore(score);

		return SUCCESS;
	}

	public String delete() {

		int flag = 0;

		if (null != ServletActionContext.getRequest().getParameter("flag")) {

			flag = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("flag"));

		}

		String scoreid = ServletActionContext.getRequest().getParameter(
				"scoreid");

		ss.deleteScore(Integer.parseInt(scoreid));

		// if(flag==2){
		return showuser();
		// /}else{
		// return showall();
		// }
	}

	public String showuser() {

		int userid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("userid"));
		ServletActionContext.getRequest().setAttribute("userid", userid);

		String hql = "from Score sc where sc.users.userid='" + userid + "'";

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		if (pageString == null || pageString.length() == 0) {
			pageString = "1";
		}
		curPage = 0;

		try {
			curPage = Integer.parseInt(pageString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (curPage == 0) {
			curPage = 1;
		}

		totalCount = ss.getTotalCount(hql);

		totalPage = ((totalCount + pageSize) - 1) / pageSize;
		if (totalPage < 1) {
			totalPage = 1;
		}
		if (curPage > totalPage) {
			curPage = totalPage;
		}

		List<Score> score = ss.queryAllScore(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("score", score);
		return "showuser";
	}

	public String showall() {

		Users user = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("user");

		int id = user.getUserid();

		String pageString = ServletActionContext.getRequest().getParameter(
				"page");

		if (pageString == null || pageString.length() == 0) {
			curPage = 1;
		} else {
			try {
				curPage = Integer.parseInt(pageString);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String hql = "from Score sc where sc.users.userid='" + id + "'";

		totalCount = ss.getTotalCount(hql);

		totalPage = ((totalCount + pageSize) - 1) / pageSize;
		if (totalPage < 1) {
			totalPage = 1;
		}
		if (curPage > totalPage) {
			totalPage = curPage;
		}

		List<Score> all = ss.queryAllScore(hql, curPage, pageSize);

		ServletActionContext.getRequest().setAttribute("all", all);

		return SUCCESS;
	}

}
