package com.kaishengit.dao;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
public class UserDaoTest {

    @Test
    public void  save() {

        //创建Spring容器，从classPath中读取Spring配置文件
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中获取对象
       // UserDao userDao = (UserDao) cxt.getBean("userDao2");
//        UserDao userDao = (UserDao) cxt.getBean("userDao");
//        UserDao userDao2 = (UserDao) cxt.getBean("com.kaishengit.dao.UserDao#1");
        UserDao userDao2 = (UserDao) cxt.getBean("userDao2");
       /* userDao2.save();*/

        cxt.close();

    }






}
