package com.kaishengit.mybatis;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.util.MyBatisUtil;

public class MyBatisTest {
	
	private Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
	
	private SqlSession sqlSession;
	
	@Before
	public void before() {
		 sqlSession = MyBatisUtil.getSqlSession();
	}
	
	@After
	public void after() {
		sqlSession.close();
	}
	
	@Test
	public void first() throws Exception{

		
		
		//�������ݿ�
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",1);

		logger.debug("{}-->{}",user.getUserName(),user.getAddress());
		
		
		
		
	}
	
	@Test
	public void findAll() throws Exception{
		
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		//�������ݿ�
		List<User> userList = sqlSession.selectList("com.kaishengit.mapper.UserMapper.findAll");
		for(User user:userList) {
			logger.debug("������{},��ַ��{}",user.getUserName(),user.getAddress());
		}
		
		
		
		
		
	}
	
	
	@Test
	public void save() throws Exception{
		
		//�������ݿ�
		
		User user = new User();
		user.setUserName("����");
		user.setAddress("֣��");
		sqlSession.insert("com.kaishengit.mapper.UserMapper.save",user);
		
		//�ύ����
		sqlSession.commit();
		
		
		
		
		
	}
	
	
	@Test
	public void update() throws Exception{
		
		
		//�������ݿ�
		User user = sqlSession.selectOne("com.kaishengit.mapper.UserMapper.findById",2);
		user.setUserName("����");
		
		sqlSession.update("com.kaishengit.mapper.UserMapper.update",user);
		
		sqlSession.commit();
		
		
		//�ύ����
		sqlSession.commit();
		
		
		
		
		
	}
	
	
	@Test
	public void delete() throws Exception{
		
		//�������ݿ�
		sqlSession.delete("com.kaishengit.mapper.UserMapper.delete",14);
		
		//�ύ����
		sqlSession.commit();
		
		
	}


}
