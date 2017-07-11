package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import com.kaishengit.dao.WeixinDao;
import com.kaishengit.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * Created by Administrator on 2017/7/8 0008.
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private WeixinDao weixinDao;

   /* public UserService(UserDao userDao, WeixinDao weixinDao) {
        this.userDao = userDao;
        this.weixinDao = weixinDao;
    }*/

      public void setWeixinDao(WeixinDao weixinDao) {
        this.weixinDao = weixinDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }



    @Transactional
    public void save(User  user) throws SQLException {
          userDao.save(user);
        /*  if(1 == 1) {
              throw new RuntimeException("执行SQL异常........");
          }*/
          userDao.save(user);
    }



    public void saveDao() {



       /* userDao.save();*/

   /*     weixinDao.sendMessage();*/
       /* if(1==1) {
            throw new RuntimeException("SQL执行出现了异常");
          }*/
        }

    public int sum() {
        return 100;

    }

}
