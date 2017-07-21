package cn.com.sky.mybatis.dao;

import java.util.List;

import cn.com.sky.mybatis.domain.Commodity;

/**
 * 定义sql映射的接口，使用注解指明方法要执行的SQL
 */
public interface CommodityMapper {

	public List<Commodity> getCommodity(int a);
}