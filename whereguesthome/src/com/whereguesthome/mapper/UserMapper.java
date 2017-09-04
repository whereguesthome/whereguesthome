package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.whereguesthome.pojo.PageBean;
import com.whereguesthome.pojo.User;
import com.whereguesthome.pojo.UserCustom;

@Repository("userMapper")
public interface UserMapper {

	int deleteByPrimaryKey(Integer uId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(Integer uId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	@Select("select u_id uId,u_name uName,u_sex uSex,u_password uPassword,u_phone uPhone,u_email uEmail,u_account uAccount from user")
	List<User> findAll();

	@Select("select u_id uId,u_name uName,u_sex uSex,u_password uPassword,u_phone uPhone,u_email uEmail,u_account uAccount from user")
	List<UserCustom> findAll1();

	// 分页查询
	List<User> selectUser(@Param("startIndex")Integer startIndex, @Param("pageNum")Integer pageNum);

	//修改用户信息
	@Update("update user set u_id=#{uId},u_sex=#{uSex},u_email=#{uEmail},u_account=#{uAccount} where u_name=#{uName}")
	int updateUser(User u );
	
	@Select("select u_id uId,u_name uName,u_sex uSex,u_password uPassword,u_phone uPhone,u_email uEmail,u_account uAccount from user where u_name=#{uName}")
	User findByuId(String uName);
}