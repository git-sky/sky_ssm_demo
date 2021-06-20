package cn.com.sky.src.service.interfaces;

import java.util.List;
import entity.Articletype;

public interface ArticletypeService {

	public void addArticletype(Articletype articletype) throws Exception;

	public void deleteArticletype(int id) throws Exception;

	public void updateArticletype(Articletype articletype) throws Exception;

	public List<Articletype> queryAllArticletype();

	public Articletype queryArticletypeByID(int id);
	
	public Articletype queryArticletypeByName(String name);
}
