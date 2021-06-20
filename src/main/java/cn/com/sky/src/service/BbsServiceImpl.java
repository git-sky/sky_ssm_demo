package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.BbsDAO;
import dao.interfaces.ReplyDAO;
import dao.interfaces.UsersDAO;

import entity.Bbs;
import entity.Reply;
import entity.Users;
import service.interfaces.BbsService;

public class BbsServiceImpl implements BbsService {

	private BbsDAO bd;
	private ReplyDAO rd;
	private UsersDAO ud;

	public ReplyDAO getRd() {
		return rd;
	}

	public void setRd(ReplyDAO rd) {
		this.rd = rd;
	}

	public void setBd(BbsDAO bd) {
		this.bd = bd;
	}

	public BbsDAO getBd() {
		return bd;
	}

	public void setUd(UsersDAO ud) {
		this.ud = ud;
	}

	public UsersDAO getUd() {
		return ud;
	}

	public void addBbs(Bbs bbs) {
		bd.save(bbs);
	}

	public void deleteBbs(int id) {
		bd.delete(id);

	}

	public Bbs queryBbsById(int id) {
		return bd.findById(id);
	}

	public Bbs queryBbsByName(String title) {
		return bd.findByTitle(title);
	}

	public void updateBbs(Bbs bbs) {
		bd.update(bbs);
	}

	@Override
	public int getTotalCount(String hql) {
		return bd.getTotalCount(hql);
	}

	@Override
	public List<Bbs> queryAllBbs(String hql, int page, int pagecount) {
		return bd.findAll(hql, page, pagecount);
	}

	@Override
	public List<Reply> queryAllReply(String hql,int curPage,int pageSize) {
		return rd.findAll(hql,curPage,pageSize);
	}

	@Override
	public Reply queryReplyById(int id) {
		return rd.findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> queryAllUsers(String hql, int page, int pageSize) {
		return ud.findAll(hql, page, pageSize);

	}

	@Override
	public Users queryUsersById(int id) {
		return ud.findById(id);
	}

}
