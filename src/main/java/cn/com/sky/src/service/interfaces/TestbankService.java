package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Chapter;
import entity.Testbank;

public interface TestbankService {

	public void addTestbank(Testbank testbank);

	public void deleteTestbank(int tbid);

	public void updateTestbank(Testbank testbank);

	public List<Testbank> queryAllTestbank(String hql, int page,
                                           int pagecount);


	public Testbank queryTestbankByName(String name);

	public Testbank queryTestbankById(int id);
	
	public int getTotalCount(String hql);

	
	public List<Chapter> queryAllChapter();
	
	public Chapter queryChapterById(int id);
	
	public List generate(String hql);
	
	


}
