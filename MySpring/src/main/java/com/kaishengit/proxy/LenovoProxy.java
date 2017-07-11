package com.kaishengit.proxy;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class LenovoProxy implements Computer {

    private Computer computer;

    public LenovoProxy(Computer computer) {

        this.computer = computer;
    }
    public void sales() {
        System.out.println("LENOVO...前置通知...");
        computer.sales();
        System.out.println("LENOVO...后置通知...");
    }
}
