package cn.com.sky.mybatis.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import cn.com.sky.mybatis.domain.Classes;
import cn.com.sky.mybatis.util.MyBatisUtil;

/**
 * <pre>
 * 
 * MyBatis一对一关联查询
 * 
 *  MyBatis一对一关联查询总结
 *  MyBatis中使用association标签来解决一对一的关联查询，association标签可用的属性如下：
 *  property:对象属性的名称
 *  javaType:对象属性的类型
 *  column:所对应的外键字段名称
 *  select:使用另一个查询封装的结果
 * 
 * </pre>
 */
public class Test3 {

	@Test
	public void testGetClass() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * cn.com.sky.mybatis.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
		 * getClass是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "cn.com.sky.mybatis.mapping.classMapper.getClass";// 映射sql的标识字符串
		// 执行查询操作，将查询结果自动封装成Classes对象返回
		Classes clazz = sqlSession.selectOne(statement, 1);// 查询class表中id为1的记录
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(clazz);// 打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1,
									// name=teacher1]]
	}

	@Test
	public void testGetClass2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * cn.com.sky.mybatis.mapping.classMapper是classMapper.xml文件中mapper标签的namespace属性的值，
		 * getClass2是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "cn.com.sky.mybatis.mapping.classMapper.getClass2";// 映射sql的标识字符串
		// 执行查询操作，将查询结果自动封装成Classes对象返回
		Classes clazz = sqlSession.selectOne(statement, 1);// 查询class表中id为1的记录
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(clazz);// 打印结果：Classes [id=1, name=class_a, teacher=Teacher [id=1,
									// name=teacher1]]
	}
}