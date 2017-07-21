package cn.com.sky.spring.orm.jdbc.template.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <pre>
 * 
 * 
 * 通过 AbstractRoutingDataSource 可以实现动态数据源切换。
 *
 * </pre>
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	@Override
	protected Object determineCurrentLookupKey() {
		return CustomerContextHolder.getCustomerType();
	}
}