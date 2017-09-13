package cn.com.sky.spring.ioc.BeanFactoryPostProcessor;

import java.sql.ResultSet;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigPropertiesUtil {

	private static Properties properties = null;

	private static final Logger logger = LoggerFactory.getLogger(ConfigPropertiesUtil.class);

	private ConfigPropertiesUtil() {

	}

	public static String getValueByKey(String key) {
		if (key == null || "".equals(key.trim())) {
			return "";
		}

		loadProperties();

		return properties.get(key) == null ? "" : properties.get(key).toString();
	}

	public static Properties getProperties() {
		loadProperties();
		return properties;
	}

	private static void loadProperties() {
		if (properties == null) {
			properties = new Properties();
			try {
				ResultSet resultSet = JDBCOperation.getProperties();
				while (resultSet.next()) {
					properties.setProperty(resultSet.getString(1), resultSet.getString(2) == null ? "" : resultSet.getString(2).trim());
				}

				logger.info("==========================加载配置数据开始============================");
				logger.info(properties.toString());
				logger.info("==========================加载配置数据结束============================");
			} catch (Exception e) {
				logger.error("加载系统配置数据出错：", e);
			} finally {

			}
		}
	}

}