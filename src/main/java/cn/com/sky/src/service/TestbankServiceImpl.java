package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.ChapterDAO;
import dao.interfaces.TestbankDAO;

import entity.Chapter;
import entity.Testbank;
import service.interfaces.TestbankService;

public class TestbankServiceImpl implements TestbankService {

	private TestbankDAO td;

	private ChapterDAO cd;

	public void setCd(ChapterDAO cd) {
		this.cd = cd;
	}

	public void setTd(TestbankDAO td) {
		this.td = td;
	}

	public void addTestbank(Testbank testbank) {
		td.save(testbank);

	}

	public void deleteTestbank(int id) {

		td.delete(id);
	}

	public Testbank queryTestbankById(int id) {
		return td.findById(id);
	}

	public Testbank queryTestbankByName(String name) {
		return td.findByTitle(name);
	}

	public void updateTestbank(Testbank testbank) {
		td.update(testbank);
	}

	@Override
	public int getTotalCount(String hql) {
		return td.getTotalCount(hql);
	}

	@Override
	public List<Testbank> queryAllTestbank(String hql, int page, int pagecount) {
		return td.findAll(hql, page, pagecount);
	}

	@Override
	public List<Chapter> queryAllChapter() {
		return cd.findAll();
	}


	@Override
	public List generate(String hql) {
		return td.generate(hql);
	}
	public Chapter queryChapterById(int id) {
		return cd.findById(id);
	}

}
