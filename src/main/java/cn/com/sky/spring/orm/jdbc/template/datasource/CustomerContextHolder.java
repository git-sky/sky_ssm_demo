package cn.com.sky.spring.orm.jdbc.template.datasource;

public class CustomerContextHolder {

	public static final String DATA_SOURCE = "dataSource";
	public static final String DATA_SOURCE_2 = "dataSource2";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	public static void setCustomerType(String customerType) {
		contextHolder.set(customerType);
	}

	public static String getCustomerType() {
		return contextHolder.get();
	}

	public static void clearCustomerType() {
		contextHolder.remove();
	}
}