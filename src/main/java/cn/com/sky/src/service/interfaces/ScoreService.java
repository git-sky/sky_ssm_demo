package cn.com.sky.src.service.interfaces;

import java.util.List;
import entity.Score;

public interface ScoreService {

	public void addScore(Score score);

	public void deleteScore(int id);

	public void updateScore(Score score);

	public List<Score> queryAllScore(String hql, int curpage, int pageSize);

	public Score queryScoreByName(String name);

	public Score queryScoreById(int id);

	public int getTotalCount(String hql);
	
	//public List generate(String hql);
}
