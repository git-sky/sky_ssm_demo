package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.BbsDAO;
import dao.interfaces.ReplyDAO;

import entity.Bbs;
import entity.Reply;
import service.interfaces.ReplyService;

public class ReplyServiceImpl implements ReplyService {

	private ReplyDAO rd;
	private BbsDAO bd;
	
	public BbsDAO getBd() {
		return bd;
	}

	public void setBd(BbsDAO bd) {
		this.bd = bd;
	}

	public void setRd(ReplyDAO rd) {
		this.rd = rd;
	}

	public ReplyDAO getRd() {
		return rd;
	}

	public void addReply(Reply reply) {
		rd.save(reply);
	}

	public void deleteReply(int id) {
		rd.delete(id);
	}

	public List<Reply> queryAllReply() {
		// TODO Auto-generated method stub
		return null;
	}

	public Reply queryReplyById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Reply queryReplyByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateReply(Reply reply) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalPage(int pageSize) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Reply> queryAllReply(String hql, int page, int pagecount) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Bbs queryBbsById(int id) {
		return bd.findById(id);
	}
	
	public void update(Bbs bbs) {
		bd.update(bbs);
	}

}
