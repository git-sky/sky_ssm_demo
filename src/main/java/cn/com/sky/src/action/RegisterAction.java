package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.RegExpValidator;

import org.apache.struts2.ServletActionContext;

import service.interfaces.UsersService;
import entity.Users;

public class RegisterAction{

	private static final long serialVersionUID = 1L;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	private UsersService us;

	private String username;
	private String pass;
	private String pass2;
	private String sex;
	private String email;
	private String qq;
	private String question;
	private String answer;

	private String checkname;
	private String error;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUs(UsersService us) {
		this.us = us;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPass() {
		return pass;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSex() {
		return sex;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getQq() {
		return qq;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

	public String getPass2() {
		return pass2;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getError() {
		return error;
	}

	public String getCheckname() {
		return checkname;
	}

	public void setCheckname(String checkname) {
		this.checkname = checkname;
	}

	// 检测数据库中是否已有该用户名
	public String check() throws Exception {
		Users u = null;
		String uu = null;
		uu = ServletActionContext.getRequest().getParameter("username");

		u = us.queryUserByName(uu);

		if (null == u) {
			checkname = null;
			return "json2";
		} else {
			checkname = u.getUsername();
			return "json2";
		}
	}

	public String add() throws Exception {
		try {
			// 服务器端的校验注册用户
			if (null == username || username.trim().length() == 0) {
				setError("用户名不能为空！");
				return "json3";
			} else if (username.trim().length() > 10
					|| username.trim().length() < 6) {
				setError("用户名必须在6-10个字符之间！");
				return "json3";
			} else if (null == pass || pass.trim().length() == 0) {
				setError("密码不能为空！");
				return "json3";
			} else if (pass.trim().length() > 10 || pass.trim().length() < 6) {
				setError("密码必须在6-10个字符之间！");
				return "json3";
			} else if (!pass2.trim().equals(pass.trim())) {
				setError("两次输入的密码不一致！");
				return "json3";

			} else if (null == question || question.trim().length() == 0) {
				setError("密码问题不能为空！");
				return "json3";
			} else if (null == answer || answer.trim().length() == 0) {
				setError("问题答案不能为空！");
				return "json3";
			} else if (!RegExpValidator.isEmail(email)) {
				setError("电子邮件格式不正确！");
				return "json3";
			} else if (null == qq || qq.trim().length() == 0) {
				setError("QQ号不能为空！");
				return "json3";

			} else if (!RegExpValidator.isDigit(qq)) {
				setError("QQ号格式不正确！");
				return "json3";
			} else if (qq.trim().length() < 6) {
				setError("QQ号太短！");
				return "json3";
			}

			Users user = new Users();
			user.setUsername(username);
			user.setPass(pass);
			user.setSex(sex);
			user.setEmail(email);
			user.setQq(qq);
			user.setQuestion(question);
			user.setAnswer(answer);
			user.setDate(sdf.format(new Date()));

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			if (null != us.queryUserByName(user.getUsername())) {
				setError("该用户名已存在！");
				return "json3";
				// return "register";
			} else {
				error=null;
				us.addUser(user);
				session.setAttribute("user", user);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "register";
	}
}
