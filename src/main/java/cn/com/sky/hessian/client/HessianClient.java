package cn.com.sky.hessian.client;

import java.net.MalformedURLException;

import cn.com.sky.hessian.service.Basic;

import com.caucho.hessian.client.HessianProxyFactory;

public class HessianClient {

    public static void main(String[] args) throws MalformedURLException {
        // String url = "http://localhost:8080/HessianWeb/hello";
        String url = "http://localhost:8080/HessianWeb/liny";
        HessianProxyFactory factory = new HessianProxyFactory();
        Basic basic = (Basic) factory.create(Basic.class, url);
        System.out.println(basic.sayHello());
    }

}