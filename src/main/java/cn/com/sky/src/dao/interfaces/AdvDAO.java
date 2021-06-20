package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Adv;

public interface AdvDAO {

	public void save(Adv adv);

	public void update(Adv adv);

	public void delete(int id);

	public List<Adv> findAll();
	
	public Adv queryAdvById(int id);
}
