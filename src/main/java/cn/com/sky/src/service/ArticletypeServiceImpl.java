package cn.com.sky.src.service;

import java.util.List;

import dao.interfaces.ArticletypeDAO;

import entity.Articletype;
import service.interfaces.ArticletypeService;

public class ArticletypeServiceImpl implements ArticletypeService {

	private ArticletypeDAO atd;
	
	public void setAtd(ArticletypeDAO atd) {
		this.atd = atd;
	}


	public void addArticletype(Articletype articletype) throws Exception {
		atd.save(articletype);
	}

	public void deleteArticletype(int id) throws Exception {
		atd.delete(id);
	}

	public List<Articletype> queryAllArticletype(){
	return atd.findAll();
	}

	public Articletype queryArticletypeByID(int id){
		return atd.findById(id);
	}

	public Articletype queryArticletypeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateArticletype(Articletype articletype) throws Exception {
		
		atd.update(articletype);
	
	}

}
