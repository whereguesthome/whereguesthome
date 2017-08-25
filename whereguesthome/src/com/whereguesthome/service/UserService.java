package com.whereguesthome.service;

import java.util.List;

import org.springframework.ui.Model;

import com.whereguesthome.pojo.User;

public interface UserService {

	// ����û�
	int insert(User record);

	// ��ѯ����
	List<User> findAll();

	boolean uname(String uName);

	/**
	 * @param id
	 *            用户id
	 * @param model
	 *            模型
	 */
	void deleteUserById(Integer id, Model model);
}
