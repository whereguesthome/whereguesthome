package com.whereguesthome.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whereguesthome.mapper.AdminMapper;
import com.whereguesthome.pojo.Admin;
import com.whereguesthome.service.AdminService;
@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	//查询管理员信息
	@Override
	public Admin selectByNmae(String aName) {
		return adminMapper.selectByNmae(aName);
	}

	
}
