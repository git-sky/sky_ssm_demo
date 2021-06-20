package cn.com.sky.src.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import service.interfaces.ReplyService;
import entity.Bbs;
import entity.Reply;
import entity.Users;

public class ReplyAction extends BaseAction {
	private ReplyService rs;

	public void setRs(ReplyService rs) {
		this.rs = rs;
	}

	Reply reply = new Reply();

	public String delete() {
		int flag=0;
		if(null!=ServletActionContext.getRequest().getParameter("flag")){
			flag=Integer.parseInt(ServletActionContext.getRequest().getParameter("flag"));
			//把标志放入request中
			ServletActionContext.getRequest().setAttribute("flag", flag);
		}
		
		
		if(null!=ServletActionContext.getRequest().getParameter("userid")){
			int userid = Integer.parseInt(ServletActionContext.getRequest()
					.getParameter("userid"));
			//把标志放入request中
			ServletActionContext.getRequest().setAttribute("userid", userid);
		}
		

		String replyid = ServletActionContext.getRequest().getParameter(
				"replyid");
		
		int bbsid = Integer.parseInt(ServletActionContext.getRequest().getParameter(
		"bbsid"));
		
		Bbs b=rs.queryBbsById(bbsid);
		
		b.setReplycount(rs.queryBbsById(bbsid).getReplycount()-1);
		
		rs.update(b);
	
		
	String page=ServletActionContext.getRequest().getParameter("page");
		
		if(null!=page){
			ServletActionContext.getRequest().setAttribute("page", page);		
		}

		
		rs.deleteReply(Integer.parseInt(replyid));
		
		return "reply";
	}

	public String add() {
		Users user=null;
		int flag=0;
		
		if(null!=ServletActionContext.getRequest().getParameter("flag")){
			flag=Integer.parseInt(ServletActionContext.getRequest().getParameter("flag"));
			//把标志放入request中
			ServletActionContext.getRequest().setAttribute("flag", flag);
		}
		
		if (null == ServletActionContext.getRequest().getSession()
				.getAttribute("user")&&null == ServletActionContext.getRequest().getSession()
				.getAttribute("admin")) {
			return LOGIN;
		}
		
		if (null != ServletActionContext.getRequest().getSession()
				.getAttribute("user")) {
			//普通用户
			user = (Users) ServletActionContext.getRequest().getSession()
					.getAttribute("user");
		} else if (null != ServletActionContext.getRequest().getSession()
				.getAttribute("admin")) {
			//管理员
			user = (Users) ServletActionContext.getRequest().getSession()
					.getAttribute("admin");
		}


		// 创建一个只有id的用户对象
		Users usr = new Users();
		usr.setUserid(user.getUserid());

		int bbsid = Integer.parseInt(ServletActionContext.getRequest()
				.getParameter("bbsid"));

		String page=ServletActionContext.getRequest().getParameter("page");
		
		if(null!=page){
			ServletActionContext.getRequest().setAttribute("page", page);		
		}

		
		Bbs b=rs.queryBbsById(bbsid);
		
		b.setReplycount(rs.queryBbsById(bbsid).getReplycount()+1);
		
		rs.update(b);
	
		// 创建一个只有id的BBS
		Bbs bbs = new Bbs();
		
		bbs.setBbsid(bbsid);
	
		reply.setUsers(usr);
		reply.setBbs(bbs);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String date = sdf.format(new Date());
		reply.setDate(date);
		
		rs.addReply(reply);
		if(flag==2){
			return "reply2";
		}else{

			return "reply";	
		}

	}

	public Reply getModel() {
		return reply;
	}
}
