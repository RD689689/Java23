package com.kaishengit.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class Test {

    public static void main(String[] arg) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Mouse.class);
        enhancer.setCallback(new MyMethodInterceptor());

        Mouse mouse = (Mouse) enhancer.create();
        mouse.move();
    }
}
