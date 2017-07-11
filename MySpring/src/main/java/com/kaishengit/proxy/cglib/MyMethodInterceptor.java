package com.kaishengit.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class MyMethodInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("闪光系列..........");
        Object result = methodProxy.invokeSuper(o,objects);//调用父类中的方法
        System.out.println("闪光..........系列......");
        return result;
    }
}
