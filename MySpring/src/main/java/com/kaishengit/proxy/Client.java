package com.kaishengit.proxy;

/**
 * Created by Administrator on 2017/7/10 0010.
 */
public class Client {

    public static void main(String[] arg) {
        Lenovo lenovo = new Lenovo();
        LenovoProxy proxy = new LenovoProxy(lenovo);
        proxy.sales();

    }
}
