package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Articletype;

public interface ArticletypeDAO {

	public void save(Articletype articletype);

	public void update(Articletype articletype);

	public void delete(int id);

	public Articletype findById(int id);

	public List findByName(String name);
	
	public List findAll();

}