package cn.com.sky.src.action;

import org.apache.struts2.ServletActionContext;
import service.interfaces.UsersService;
import entity.Users;

/*
 * 修改管理员信息模块
 */
public class AdminAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	private UsersService us;

	Users user = new Users();

	public void setUs(UsersService us) {
		this.us = us;
	}

	public String update() throws Exception {
		// 取得session中的admin，用于修改。
		Users admin = (Users) ServletActionContext.getRequest().getSession()
				.getAttribute("admin");

		ServletActionContext.getRequest().setAttribute("admin", admin);

		return "update";
	}

	public String updatesubmit() throws Exception {
		// 更新admin信息，并且把更新后的admin放入session中。
		us.updateUser(user);
		ServletActionContext.getRequest().getSession().setAttribute("admin",
				user);
		return "updatesubmit";
	}

	public String logout() {
		//退出登录
		ServletActionContext.getRequest().getSession().removeAttribute("admin");
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}

	public Users getModel() {
		return user;
	}

}
