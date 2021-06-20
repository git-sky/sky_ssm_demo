package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.ScoreDAO;

import entity.Score;
import service.interfaces.ScoreService;

public class ScoreServiceImpl implements ScoreService {
	private ScoreDAO sd;

	public void setSd(ScoreDAO sd) {
		this.sd = sd;
	}

	public ScoreDAO getSd() {
		return sd;
	}

	public void addScore(Score score) {
		sd.save(score);
	}

	public void deleteScore(int id) {
		sd.delete(id);
	}

	public Score queryScoreById(int id) {
		return sd.findById(id);
	}

	public void updateScore(Score score) {

	}

	@Override
	public Score queryScoreByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalCount(String hql) {
		return sd.getTotalCount(hql);
	}

	@Override
	public List<Score> queryAllScore(String hql, int curPage, int pageSize) {
		return sd.findAll(hql, curPage, pageSize);
	}


}
