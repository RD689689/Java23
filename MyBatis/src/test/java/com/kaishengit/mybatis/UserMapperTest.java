package com.kaishengit.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kaishengit.entity.User;
import com.kaishengit.mapper.UserMapper;
import com.kaishengit.util.MyBatisUtil;

public class UserMapperTest {

	private Logger logger = LoggerFactory.getLogger(UserMapperTest.class);
	
	private SqlSession sqlSession;
	private UserMapper userMapper; 
	
	@Before
	public void before() {
		sqlSession = MyBatisUtil.getSqlSession();
		//MyBatis���ݶ����Mapper�ӿڶ�̬�����ɸýӿڵ�ʵ����
		//�ӿ�ָ��ʵ����
		//��̬����ģʽ
		userMapper = sqlSession.getMapper(UserMapper.class);
		
	}
	
	
	@After
	public void after() {
		sqlSession.close();
	}
	
	@Test
	public void findById() {
		User user = userMapper.findById(1);
		logger.debug("����:{}--->��ַ:{}",user.getUserName(),user.getAddress());
	}
	
	@Test
	public void save() {
		User user = new User();
		user.setUserName("����");
		user.setAddress("����");
		
		userMapper.save(user);
		sqlSession.commit();
	}
	
	@Test
	public void findAll() {
		List<User> userList = userMapper.findAllLoadDept();
		for(User user:userList) {
			
			logger.debug("����:{} ---> ��ַ:{} ---> ����:{}",user.getUserName(),user.getAddress(),user.getDept().getDeptName());
		}
		
	}
	
	
}