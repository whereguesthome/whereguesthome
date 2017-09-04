package com.whereguesthome.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.UserMapper;
import com.whereguesthome.md5.md5jdkUtil;
import com.whereguesthome.pojo.PageBean;
import com.whereguesthome.pojo.User;
import com.whereguesthome.pojo.UserCustom;
import com.whereguesthome.service.UserService;

@Service("userService")
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper userMapper;
   
	//修改用户信息
	public int updateUser(User u){
		
		return userMapper.updateUser(u);
	}
	@Override
	public User findByuId(String uName) {		
		return userMapper.findByuId(uName);
	}

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
	public boolean deleteUserById(Integer id, Model model) {
		String msg = null;
		boolean flag = false;
		if (id != null) {
			int a = userMapper.deleteByPrimaryKey(id);
			if (a == 0) {
				msg = "删除失败";
				model.addAttribute("msg", msg);
				flag = false;
			} else if (a > 0) {
				msg = "删除成功";
				model.addAttribute("msg", msg);
				flag = true;
			}
		} else {
			msg = "用户id不存在";
			model.addAttribute("msg", msg);
			flag = false;
		}
		return flag;
	}

	// 分页查询后台用户列表
	@Override
	public void backgroundUserDisplay(Model model, Integer pageNumber) {

		int currentPage = 1;// 默认页码
		int pageSize = 3;// 默认每页记录数
		if (pageNumber != null) {
			currentPage = pageNumber;
		}
		// 总记录数
		List<User> list1 = userMapper.findAll();
		int totalRecord = list1.size();
		PageBean<User> users = new PageBean<>();
		users.setPageNumber(currentPage);
		users.setTotalRecord(totalRecord);
		users.setPageSize(pageSize);
		// 调用持久层获取用户所有数据
		List<User> list = userMapper.selectUser(users.getStartIndex(), pageSize);
		users.setData(list);
		model.addAttribute("users", users);
	}

	
}
