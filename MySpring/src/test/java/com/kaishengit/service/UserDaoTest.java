package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by Administrator on 2017/7/11 0011.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    @Test
    public void service () throws Exception{

        User user = new User();
        user.setAddress("北京");
        user.setDept_Id(1);
        user.setPassword("121212");
        user.setUser_name("金哲");

        userService.save(user);

    }

    @Test
    public void save() {

        User user = new User();
        user.setAddress("北京");
        user.setDept_Id(1);
        user.setPassword("121212");
        user.setUser_name("林寒");

        userDao.save(user);
    }
    @Test
    public void findById() {
      User user =  userDao.findById(1);
        Assert.assertNotNull(user);
        System.out.println(user.getAddress());
    }
    @Test
    public void findByName() {
        User user = userDao.findByUserName("林寒");
        Assert.assertEquals(user.getId().intValue(),41);
        System.out.println(user.getUser_name() + "---->" + user.getAddress() + "--->" + user.getPassword());
    }
    @Test
    public void count() {
        Long count = userDao.count();
        Assert.assertEquals(16L,count.longValue());
    }

    @Test
    public void findByAddress() {
        List<User> userList = userDao.findByAddress("郑州");
        for(User user:userList) {
            System.out.println(user.getUser_name() + "---->" + user.getPassword() + "---->" + user.getAddress());
        }
    }

    @Test
    public void findAll() {
        List<User> userList = userDao.findAll();
        Assert.assertEquals(userList.size(),16);
        for(User user:userList) {
            System.out.println(user.getUser_name() + "---->" + user.getPassword() + "---->" + user.getAddress());
        }
    }

}
