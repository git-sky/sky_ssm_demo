package cn.com.sky.src.action;

import org.apache.struts2.ServletActionContext;

import entity.Users;

import service.interfaces.UsersService;

public class ForgetAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	UsersService us;

	String username;
	String question;
	String answer;

	public UsersService getUs() {
		return us;
	}

	public void setUs(UsersService us) {
		this.us = us;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	@Override
	public void validate() {

		if (null == username || username.trim().length() == 0) {
			addFieldError("username", "用户名不能为空！");

		} else if (null == question || question.trim().length() == 0) {
			addFieldError("question", "密码问题不能为空！");
		} else if (null == answer || answer.trim().length() == 0) {
			addFieldError("answer", "问题答案不能为空！");
		}

	}

	@Override
	public String execute() {
		Users user = null;
		try {
			user = us.queryUserByName(username);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (null == user) {
			this.addActionError("该用户不存在！");
		} else if (!question.equals(user.getQuestion())
				|| !answer.equals(user.getAnswer())) {
			this.addActionError("密码问题或问题答案不正确！");

		} else {
			ServletActionContext.getRequest().getSession().setAttribute("user",
					user);
			return SUCCESS;
		}
		return INPUT;

	}
}
