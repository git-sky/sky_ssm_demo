package cn.com.sky.src.dao.interfaces;

import java.util.List;

import entity.Testbank;

public interface TestbankDAO {

	public static final String TITLE = "title";
	public static final String A = "a";
	public static final String B = "b";
	public static final String C = "c";
	public static final String D = "d";
	public static final String ANSWER = "answer";

	public void save(Testbank testbank);

	public void update(Testbank testbank);

	public void delete(int id);

	public Testbank findById(int id);

	public List findByProperty(String propertyName, Object value);

	public Testbank findByTitle(String title);

	public List findByA(Object a);

	public List findByB(Object b);

	public List findByC(Object c);

	public List findByD(Object d);

	public List findByAnswer(Object answer);

	public List findAll(String hql, int page, int pagecount);

	// 总条数
	public int getTotalCount(String hql);
	
	public List generate(String hql);

}