package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Score;

public interface ScoreDAO {

	public void save(Score score);

	public void update(Score score);

	public void delete(int id);

	public Score findById(int id);
	
	public List<Score> findAll(String hql, int curpage, int pageSize);
	
	public int getTotalCount(String hql);
	
	//public List generate(String hql);

	List findScoreByUserId(int id);

}