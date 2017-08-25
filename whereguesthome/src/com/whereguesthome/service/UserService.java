package com.whereguesthome.service;

import java.util.List;

import com.whereguesthome.pojo.User;

public interface UserService {
	   

    //添加用户
	    int insert(User record);
   
	    //查询所有
	    List<User> findAll();
   
	    
	    boolean uname(String uName);
}
