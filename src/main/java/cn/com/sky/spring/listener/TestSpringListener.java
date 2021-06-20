package cn.com.sky.spring.listener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;

/**
 *
 */
public class TestSpringListener {

    public static void main(String[] args) {

        ServletContextListener servletContextListener;

        ContextLoaderListener contextLoaderListener;

        ServletContext sc = null;

        WebApplicationContextUtils.getWebApplicationContext(sc);

    }

}