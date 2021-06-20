package cn.com.sky.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextListener;

/**
 * <pre>
 * 参考：https://zhuanlan.zhihu.com/p/65219353
 *
 * 6个常规监听器
 *     |---ServletContext
 *             |---ServletContextListener（生命周期监听）
 *             |---ServletContextAttributeListener（属性监听）
 *     |---HttpSession
 *             |---HttpSessionListener（生命周期监听）
 *             |---HttpSessionAttributeListener（属性监听）
 *     |---ServletRequest
 *             |---ServletRequestListener（生命周期监听）
 *             |---ServletRequestAttributeListener（属性监听）
 *
 * 2个感知监听
 *     |---HttpSessionBindingListener
 *     |---HttpSessionActivationListener
 *
 *
 * 6个常规监听器，分属三类，分别对应JavaWeb三大域对象（除去JSP的Page域）：ServletContext、HttpSession、ServletRequest。
 * 共三对，每一对都包括1个生命周期监听和1个属性监听。
 *
 * 所谓生命周期监听器，就是监听三大域对象的创建和销毁。
 * 每当Tomcat创建或销毁三大域对象，都会被这些监听器察觉，然后它们会做相应的操作（调用自身的特定方法）。
 *
 * 属性监听器则专门监听三大域对象get/setAttribute()。
 * 每当我们给域对象设置值或者从里面取值，都会被它们监听到，然后还是触发它们特定的方法。
 *
 *   </pre>
 */
public class TestServletListener {


    public static void main(String[] args) {

        ServletContextListener servletContextListener;

        ServletContext sc = null;

    }
}