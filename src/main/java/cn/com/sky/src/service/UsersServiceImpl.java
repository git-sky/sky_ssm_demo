package cn.com.sky.src.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.interfaces.BbsDAO;
import dao.interfaces.ResourceDAO;
import dao.interfaces.ScoreDAO;
import dao.interfaces.UsersDAO;

import entity.Users;
import service.interfaces.UsersService;

public class UsersServiceImpl implements UsersService {

	private UsersDAO ud;

	private BbsDAO bd;

	private ResourceDAO rd;

	private ScoreDAO sd;

	public BbsDAO getBd() {
		return bd;
	}

	public void setBd(BbsDAO bd) {
		this.bd = bd;
	}

	public ResourceDAO getRd() {
		return rd;
	}

	public void setRd(ResourceDAO rd) {
		this.rd = rd;
	}

	public ScoreDAO getSd() {
		return sd;
	}

	public void setSd(ScoreDAO sd) {
		this.sd = sd;
	}

	public void setUd(UsersDAO ud) {
		this.ud = ud;
	}

	public void addUser(Users user) throws Exception {
		ud.save(user);
	}

	@SuppressWarnings("unchecked")
	public boolean checkUser(Users user) throws Exception {

		List users = ud.checkUser(user);
		if (users.size() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean checkAdmin(Users user) throws Exception {
		List users = ud.checkAdmin(user);
		if (users.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	public void deleteUser(int id) throws Exception {
		ud.delete(id);
	}

	public List<Users> queryAllUser(String hql, int page, int pagecount) {
		return ud.findAll(hql, page, pagecount);
	}

	public Users queryUserById(int id) {
		return ud.findById(id);
	}

	public Users queryAdminByName(String name) {
		return ud.findByAdmin(name);
	}

	public Users queryUserByName(String username) throws Exception {
		return ud.findByUsername(username);
	}

	public void updateUser(Users user) throws Exception {
		ud.update(user);
	}

	@Override
	public int getTotalCount(String hql) {
		return ud.getTotalCount(hql);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map show(int id) throws Exception {

		Map m = new HashMap();

		List bbs = bd.findBbsByUserId(id);
		List res = rd.findResourceByUserId(id);
		List score = sd.findScoreByUserId(id);

		m.put("bbs", bbs);

		m.put("resource", res);
		m.put("score", score);

		return m;
	}

}
