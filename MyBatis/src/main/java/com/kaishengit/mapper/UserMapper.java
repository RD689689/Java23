package com.kaishengit.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Options.FlushCachePolicy;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.kaishengit.entity.User;

@CacheNamespace
public interface UserMapper {
	
	@Select("select * from t_user where id = #{id}")
	@Options(useCache=false)
	User findById(Integer id);
	
	@Select("select * from t_user")
	List<User> findAll();
	
	@Insert("insert into t_user(user_name,address,dept_Id,password) values(#{userName},#{address},#{deptId},#{password})")
	@Options(useGeneratedKeys=true,keyProperty="id",flushCache=FlushCachePolicy.FALSE)
	void save(User user);
	
	void batchSave(List<User> userList);
	
	@Update("update t_user set user_name = #{userName},address = #{address} where id = #{id}")
	void update(User user);
	
	@Delete("delete from t_user where id=#{id}")
	void delete(Integer id);
	
	List<User> findAllLoadDept();
	
	@Select("select * from t_user where user_name = #{name} and password = #{pass}")
	User findUserByMap(Map<String,Object> map);
	
	@Select("select * from t_user where user_name = #{arg0} and address = #{arg1}")
	User findUserByNameAndAdress(String userName,String address);
	
	@Select("select * from t_user where user_name = #{userName} and password = #{password}")
	User findByUserNameAndPassword(@Param("userName") String userName,
									@Param("password") String password);
	
	List<User> searchByNameAndAddress(Map<String,Object> map);
	
	List<User> searchByNameAndAddress2(@Param("name") String userName,
										@Param("add") String add);
	
	void deleteById(List<Integer> idList);
	
}
