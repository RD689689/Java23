package com.kaishengit.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class ComputerInvocationHandler implements InvocationHandler {

    //指定目标对象
    private Object target;
    public ComputerInvocationHandler(Object object) {
        this.target = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       System.out.println("每台机子加价 -------> 600");
       Object result = method.invoke(target,args);
        return result;
    }
}
