package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Resourcetype;

public interface ResourcetypeDAO {

	public void save(Resourcetype resourcetype);

	public void update(Resourcetype resourcetype);

	public void delete(int id);

	public Resourcetype findById(int id);

	public List findByResourcename(String resourcename);

	public List findAll();

}