package com.whereguesthome.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whereguesthome.mapper.UserMapper;
import com.whereguesthome.md5.md5jdkUtil;
import com.whereguesthome.pojo.User;
import com.whereguesthome.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	
	

	@Override
	public int insert(User record) {
			String md5=md5jdkUtil.getMd5(record.getuPassword());
			record.setuPassword(md5);
		return userMapper.insert(record);
		
	}
	
		//ע���ѯ���ݿ��û����Ƿ����
		public boolean uname(String uName){
			 boolean flag=false;
			List<User> list=userMapper.findAll();
			for(User users:list){
				 if(uName.equals(users.getuName())){
					 flag=true;//�ظ�
					 break;
				 }else{
					 flag=false;//���ظ�
				 }
			 }
			 return flag;
		}
		


	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

}
