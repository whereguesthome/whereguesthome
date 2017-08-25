package com.whereguesthome.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.UserMapper;
import com.whereguesthome.md5.md5jdkUtil;
import com.whereguesthome.pojo.User;
import com.whereguesthome.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int insert(User record) {
		String md5 = md5jdkUtil.getMd5(record.getuPassword());
		record.setuPassword(md5);
		return userMapper.insert(record);

	}

	// ע���ѯ���ݿ��û����Ƿ����
	public boolean uname(String uName) {
		boolean flag = false;
		List<User> list = userMapper.findAll();
		for (User users : list) {
			if (uName.equals(users.getuName())) {
				flag = true;// �ظ�
				break;
			} else {
				flag = false;// ���ظ�
			}
		}
		return flag;
	}

	@Override
	public List<User> findAll() {
		return userMapper.findAll();
	}

	// 根据id删除用户
	@Override
	public void deleteUserById(Integer id, Model model) {
		String msg = null;
		if (id != null) {
			userMapper.deleteByPrimaryKey(id);
			msg = "删除成功";
			model.addAttribute("msg", msg);
		} else {
			msg = "删除失败";
			model.addAttribute("msg", msg);
		}

	}

}
