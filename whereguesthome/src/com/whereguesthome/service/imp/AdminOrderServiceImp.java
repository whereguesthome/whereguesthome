package com.whereguesthome.service.imp;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.AdminOrderMapper;
import com.whereguesthome.pojo.GoodsItems;
import com.whereguesthome.pojo.Order;
import com.whereguesthome.service.AdminOrderService;

@Service
public class AdminOrderServiceImp implements AdminOrderService{

	@Autowired
	private AdminOrderMapper adminOrderMapper;
	
	@Override
	public int deleteByPrimaryKey(Model model,Integer oId) {
		
		int i = adminOrderMapper.deleteByPrimaryKey(oId);
		int a = adminOrderMapper.deleteItems(oId);
		if(i>0&&a>0){
			model.addAttribute("msg", "删除成功！");
		}else{
			model.addAttribute("msg2", "删除失败！");
		}
		return i;
	}

	@Override
	public int insertSelective(Order record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectByPrimaryKey(Model model,Integer oId,Integer uId) {
		
		Order order = adminOrderMapper.selectByPrimaryKey(oId);
		List<GoodsItems> listg  = adminOrderMapper.gfindAll(uId);
	
		model.addAttribute("order", order);
		model.addAttribute("listg", listg);
	}

	@Override
	public int updateByPrimaryKeySelective(Order record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectAll(Model model) {
		
		List<Order> listOrder = adminOrderMapper.selectAll();
		
		
		if(listOrder!=null){
			model.addAttribute("listOrder", listOrder);
		}else{
			model.addAttribute("msg", "没有数据！");
		}
	}

	@Override
	public void selectAllDim(HttpServletRequest request,Model model) {
		
		String mName = "%"+request.getParameter("shuru")+"%";
		List<Order> listOrder = adminOrderMapper.selectAllDim(mName);
		
		if(listOrder!=null&&listOrder.size()!=0){
			model.addAttribute("listOrder", listOrder);
		}else{
			model.addAttribute("dimMsg", "没有数据");
		}
		
	}

}
