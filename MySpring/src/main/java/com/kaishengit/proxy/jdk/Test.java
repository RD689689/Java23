package com.kaishengit.proxy.jdk;

import com.kaishengit.proxy.Computer;
import com.kaishengit.proxy.Lenovo;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class Test {
    public static void main(String[] arg) {
       //目标对象
        Lenovo lenovo = new Lenovo();
        //Handler对象
        ComputerInvocationHandler invocationHandler = new ComputerInvocationHandler(lenovo);
        //接口指向（动态）代理对象
        Computer computer = (Computer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(),
                lenovo.getClass().getInterfaces(),invocationHandler);
        computer.sales();




    }
}
