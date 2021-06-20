package cn.com.sky.src.service.interfaces;

import java.util.List;

import entity.Bbs;
import entity.Reply;

public interface ReplyService {


	public void addReply(Reply reply);

	public boolean updateReply(Reply reply);

	public void deleteReply(int id);

	public List<Reply> queryAllReply(final String hql, final int page, final int pagecount);

	// 总条数
	public int getTotalCount();

	// 总页数
	public int getTotalPage(int pageSize);


	public Reply queryReplyByName(String name);

	public Reply queryReplyById(int id);
	
	public Bbs queryBbsById(int id);
	
	public void update(Bbs bbs);


}
