package cn.com.sky.spring.ioc.BeanFactoryPostProcessor;

import java.util.Properties;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class DataBasePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {

	@Override
	public Properties mergeProperties() {
		return ConfigPropertiesUtil.getProperties();
	}

}