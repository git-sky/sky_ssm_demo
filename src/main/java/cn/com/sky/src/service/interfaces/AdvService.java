package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Adv;

public interface AdvService {
	
	public void addAdv(Adv adv);

	public void updateAdv(Adv adv);

	public void deleteAdv(int id);

	public List<Adv> queryAll();
	
	public Adv queryAdvById(int id);

}
