package com.kaishengit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.Dept;
import com.kaishengit.entity.User;
import com.kaishengit.mapper.DeptMapper;
import com.kaishengit.util.MyBatisUtil;

public class DeptMapperTest {

	private Logger logger = LoggerFactory.getLogger(DeptMapperTest.class);
	
	private SqlSession sqlSession;
	private DeptMapper deptMapper;
	
	@Before
	public void before() {
		sqlSession = MyBatisUtil.getSqlSession();
		deptMapper = sqlSession.getMapper(DeptMapper.class);
	}
	
	@After 
	public void after() {
		sqlSession.close();
	}
	
	@Test
	public void findById() {
		Dept dept = deptMapper.findByIdLoadUser(1);
		logger.debug("²¿ÃÅ:-----> {}",dept.getDeptName());
		
		List<User> userList = dept.getUserList();
		for(User user : userList) {
			logger.debug("ÐÕÃû -----> {}",user.getUserName());
		}
		
	}
	
	
}
