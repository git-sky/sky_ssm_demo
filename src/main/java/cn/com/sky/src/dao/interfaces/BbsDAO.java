package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Bbs;

public interface BbsDAO {

	public void save(Bbs bbs);

	public void update(Bbs bbs);

	public void delete(int id);

	public Bbs findById(int id);

	public Bbs findByTitle(String title);

	public List findAll(String hql, int page, int pagecount);

	public int getTotalCount(String hql);

	List findBbsByUserId(int id);


}