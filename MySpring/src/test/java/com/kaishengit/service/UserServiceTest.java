package com.kaishengit.service;

import com.kaishengit.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void save() {
        userService.saveDao();
        userService.sum();
    }


    /*@Test
    public void saveService() {
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) cxt.getBean("userService");
//        userService.saveDao();
        userService.sum();
        cxt.close();

        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("applicationContext.xml");
        Didemo diDemo = (Didemo) cxt.getBean("diDemo");
        diDemo.show();
    }*/
}
