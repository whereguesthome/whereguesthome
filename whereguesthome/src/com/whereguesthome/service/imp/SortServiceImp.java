package com.whereguesthome.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.SortMapper;
import com.whereguesthome.pojo.Sort;
import com.whereguesthome.service.SortService;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
@Service
public class SortServiceImp implements SortService{

	@Autowired
	private SortMapper sortMapper;
	
	//根据ID删除分类信息
	@Override
	public int deleteByPrimaryKey(Integer sId,Model model) {
		String msg = null;
		int a = 0;
		if(sId!=null){
			int i = sortMapper.deleteByPrimaryKey(sId);
			if(i>0){
				msg = "删除成功!";
				model.addAttribute("msg", msg);
				a = 1;
			}else{
				msg = "删除失败!";
				model.addAttribute("msg", msg);
				a = 0;
			}
		}else{
			msg = "该分类不存在";
			model.addAttribute("msg", msg);
			a = 0;
		}
			return a;
		
	}

	//添加分类信息
	@Override
	public boolean insertSelective(Sort record,Model model) {
		boolean flag = false;
		String msg = null;
		if(record!=null){
			int  i = sortMapper.insertSelective(record);
			if(i>0){
				msg = "添加成功！";
				model.addAttribute("msg", msg);
				flag = true;
			}else{
				msg = "添加失败！";
				model.addAttribute("msg", msg);
				flag = false;;
			}
		}else{
			msg = "添加失败！";
			model.addAttribute("msg", msg);
			flag = false;;
		}
		return flag;
	}

	//根据ID查询分类信息
	@Override
	public void selectByPrimaryKey(Integer sId,Model model) {
		
		String msg = null;
		Sort sort = sortMapper.selectByPrimaryKey(sId);
		
		if(sort!=null){
			model.addAttribute("sort", sort);
			
		}else{
			msg = "没有数据";
			model.addAttribute("msg", msg);
		}
		
	}

	//更新分类信息
	@Override
	public int updateByPrimaryKeySelective(Sort record,Model model) {
		
		String msg = null;
		int a = 0;
		int i = sortMapper.updateByPrimaryKeySelective(record);
		if(i>0){
			msg = "更新成功！";
			model.addAttribute("msg", msg);
			a = 1;
		}else{
			msg = "更新失败！";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
	}

	//查询所有类别信息
	@Override
	public void SelectAll(Model model) {
		String msg = null;
		List<Sort> list = sortMapper.SelectAll();
		
		if(!list.isEmpty()){
			model.addAttribute("list",list);

		}else{
			msg="没有数据!";
			model.addAttribute("msg",msg);
		}
				
	}

}
