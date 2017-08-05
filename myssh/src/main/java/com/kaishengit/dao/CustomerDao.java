package com.kaishengit.com.kaishengit.dao;

import com.kaishengit.pojo.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/4 0004.
 */
@Repository
public class CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * 获取Session
     * @return
     */
    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 根据ID查找对象
     * @param id
     * @return
     */
    public Customer findById(Integer id) {
        return (Customer) getSession().get(Customer.class,id);
    }

    /**
     * 保存或更新对象
     * @param customer
     */
    public void save(Customer customer) {
        getSession().saveOrUpdate(customer);
    }

    /**
     * 查询全部
     * @return
     */
    public List<Customer> findAll() {
        Criteria criteria = getSession().createCriteria(Customer.class);
        return criteria.list();
    }


    /**
     * 根基ID删除对象
     * @param id
     */
    public void deleteById(Integer id) {
        getSession().delete(findById(id));
    }

    /**
     * 删除对象
     * @param customer
     */
    public void delete(Customer customer) {
        getSession().delete(customer);
    }

    public List<Customer> findByProperty(String str, Object property) {
        Criteria criteria = getSession().createCriteria(Customer.class);
        criteria.add(Restrictions.eq(str,property));

        return criteria.list();
    }
}
