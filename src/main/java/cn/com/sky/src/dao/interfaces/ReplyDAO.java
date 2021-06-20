package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Reply;

public interface ReplyDAO {

	public void save(Reply reply);

	public Reply findById(int id);

	public void delete(int id);

	public List findAll(String hql, int curPage, int pageSize);

	// 总条数
	public int getTotalCount();

	// 总页数
	public int getTotalPage(int pageSize);

}