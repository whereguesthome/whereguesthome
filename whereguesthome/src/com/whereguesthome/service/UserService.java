package com.whereguesthome.service;

import java.util.List;

import com.whereguesthome.pojo.User;

public interface UserService {
	   

    //����û�
	    int insert(User record);
   
	    //��ѯ����
	    List<User> findAll();
   
	    
	    boolean uname(String uName);
}
