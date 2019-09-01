package cn.com.sky.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.com.sky.mybatis.domain.Commodity;

/**
 * 定义sql映射的接口，使用注解指明方法要执行的SQL
 */
public interface CommodityMapperI {

    @Select("SELECT d.rebate_ratio AS rebate_ratio, d.id AS plan_id, t.id AS item_id, t.name AS item_name, d.merchant_scopes AS shop_no FROM t_rebate_plan_commodity t, t_rebate_plan d WHERE t.plan_Id = d.id AND t.flow = 14 AND t.status = -1 AND t.type = 6 ")
    List<Commodity> getAll();
}