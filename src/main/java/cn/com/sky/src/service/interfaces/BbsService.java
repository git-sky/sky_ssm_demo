package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Bbs;
import entity.Reply;
import entity.Users;

public interface BbsService {

	public void addBbs(Bbs bbs);

	public void deleteBbs(int id);

	public void updateBbs(Bbs bbs);

	public List<Bbs> queryAllBbs(String hql, int curPage, int pageSize);

	public int getTotalCount(String hql);


	public Bbs queryBbsById(int id);

	public Bbs queryBbsByName(String name);

	public List<Reply> queryAllReply(String hql, int curPage, int pageSize);

	public Reply queryReplyById(int id);

	public List<Users> queryAllUsers(String hql, int page, int pageSize);

	public Users queryUsersById(int id);
}
