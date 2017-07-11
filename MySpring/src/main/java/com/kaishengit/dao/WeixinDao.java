package com.kaishengit.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
@Repository
public class WeixinDao {

    public WeixinDao() {
        System.out.println("createWeixinDao构造方法");
    }

    public void sendMessage() {
        System.out.println("sendMessage....发送信息");
    }
}
