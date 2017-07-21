package cn.com.sky.mybatis.test;

import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.com.sky.mybatis.dao.CommodityMapperI;
import cn.com.sky.mybatis.domain.Commodity;
import cn.com.sky.mybatis.domain.User;
import cn.com.sky.mybatis.util.MyBatisUtil;

public class TestCommodity2 {

	public static void main(String[] args) {
		// SqlSession sqlSession = MyBatisUtil.getSqlSession();
		//
		// String statement = "cn.com.sky.mybatis.mapping.commodityMapper.getCommodity";//
		// 映射sql的标识字符串
		// // 执行查询返回一个唯一user对象的sql
		// List<Commodity> clist = sqlSession.selectList(statement);
		// for (Iterator iterator = clist.iterator(); iterator.hasNext();) {
		// Commodity commodity = (Commodity) iterator.next();
		// System.out.println(commodity);
		// }
		// sqlSession.close();

		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		// 得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
		CommodityMapperI mapper = sqlSession.getMapper(CommodityMapperI.class);
		// 执行查询操作，将查询结果自动封装成List<User>返回
		List<Commodity> lstUsers = mapper.getAll();
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(lstUsers);
	}
}