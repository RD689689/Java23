package com.kaishengit.mybatis;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		user.setUserName("��ս");
		user.setAddress("����");
		user.setDeptId(1);
		user.setPassword("123456");
		
		userMapper.save(user);
		System.out.println("ID -------->" + user.getId());
		sqlSession.commit();
//		System.out.println("ID -------->" + user.getId());
	}
	
	@Test
	public void findAll() {
		List<User> userList = userMapper.findAllLoadDept();
		for(User user:userList) {
			
			logger.debug("����:{} ---> ��ַ:{} ---> ����:{}",user.getUserName(),user.getAddress(),user.getDept().getDeptName());
		}
		
	}
	
	
	
	
	@Test 
	public void findByUserNameAndPassword() {
		User user = userMapper.findByUserNameAndPassword("����", "111111");
		System.out.println(user.getId());
		
	}
	
	@Test
	public void findUserByNameAndAddress() {
		
		User user = userMapper.findUserByNameAndAdress("����", "֣��");
		System.out.println(user.getUserName());
	}
	
	@Test
	public void findUserByMap() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "����");
		map.put("pass", "333333");
		
		User user = userMapper.findUserByMap(map);
		System.out.println(user.getUserName() + "--->" + user.getAddress());
	}
	
	
	@Test
	public void searchByNameAndAddress() {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", "����");
		map.put("add", "֣��");
		
		List<User> userList = userMapper.searchByNameAndAddress(map);
		for(User user:userList) {
			System.out.println(user.getUserName() + "----->" + user.getAddress() + "----->" + user.getPassword());
			
		}
		
		
	}
	
	
	@Test
	public void searchByUserNameAndAddress2() {
		
		List<User> userList = userMapper.searchByNameAndAddress2("��ս","����");
		for(User user:userList) {
			
			System.out.println(user.getUserName() + "--->" + user.getAddress() + "--->" + user.getPassword());
			
		}
		
		
	}
	
	@Test 
	public void deleteById() {
		List<Integer> idList = Arrays.asList(29,30,31);
		userMapper.deleteById(idList);
		sqlSession.commit();
	}
	
	@Test
	public void batchSave() {
		List<User> userList = Arrays.asList(new User("Jack","����","111111",1),
				new User("��ɭ��","�¹�","111111",1),
				new User("����","�й�","111111",1));
		
		userMapper.batchSave(userList);
		sqlSession.commit();
	}
	
	@Test
	public void findUserById(){
		User user = userMapper.findById(1);
		User user2 = userMapper.findById(1);
		
		System.out.println(user2.getUserName());
	}
	
	@Test
	
	public void findId(){
		SqlSession session1= MyBatisUtil.getSqlSession();
		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
		
		User user1 = userMapper1.findById(1);
		System.out.println(user1.getUserName());
		session1.close();
		
		System.out.println("---------------------------------------------");
		
		
		SqlSession session2= MyBatisUtil.getSqlSession();
		UserMapper userMapper2 = session2.getMapper(UserMapper.class);
		
		User user2 = userMapper2.findById(1);
		System.out.println(user2.getUserName());
		session2.close();
		
	}
	
}
