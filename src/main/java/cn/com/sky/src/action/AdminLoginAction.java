package cn.com.sky.src.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import service.interfaces.UsersService;
import entity.Users;

/*
 * 管理员登录模块
 */

public class AdminLoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private UsersService us;

	private String name;

	private String password;

	private String validationCode;

	public void setUs(UsersService us) {
		this.us = us;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}

	@Override
	public void validate() {
		String vCode = (String) ServletActionContext.getRequest().getSession()
				.getAttribute("vCode");

		if (null == name || name.trim().length() == 0) {
			addFieldError("name", "用户名不能为空！");

		} else if (null == password || password.trim().length() == 0) {
			addFieldError("password", "密码不能为空！");
		} else if (!vCode.equalsIgnoreCase(validationCode)) {
			addFieldError("validationCode", "验证码错误！");
		}

	}

	@Override
	public String execute() throws Exception {
		try {

			Users user = new Users();

			user.setUsername(name);
			user.setPass(password);

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();

			if (us.checkAdmin(user)) {

				Users usr = us.queryAdminByName(user.getUsername());

				session.setAttribute("admin", usr);

				session.setMaxInactiveInterval(24 * 2600);

				return SUCCESS;
			}else{
				this.addActionError("管理员名称或者密码错误！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return LOGIN;
	}

}
