package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.whereguesthome.pojo.User;

@Repository("userMapper")
public interface UserMapper {
	
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    @Select("select u_id uId,u_name uName,u_password uPassword,u_phone uPhone,u_email uEmail,u_account uAccount from user")
    List<User> findAll();
}