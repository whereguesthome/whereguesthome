package com.whereguesthome.service.imp;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import com.whereguesthome.mapper.GoodsMapper;
import com.whereguesthome.mapper.SortMapper;
import com.whereguesthome.pojo.Goods;
import com.whereguesthome.pojo.PageBean;
import com.whereguesthome.pojo.Sort;
import com.whereguesthome.service.GoodsService;
import com.whereguesthome.upphoto.UpPhoto;

@Service
public class GoodsServiceImp implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	@Autowired
	private SortMapper sortMapper;;

	// 查询所有的商品信息
	@Override
	public void selectAll(Model model) {
		List<Sort> listSort2 = sortMapper.SelectAll();
		List<Goods> goodslist = goodsMapper.selectAll();
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("listSort2", listSort2);
	}

	// 根据ID删除商品信息
	@Override
	public int deleteByPrimaryKey(Integer gId,Model model) {
		String msg = null;
		int i = goodsMapper.deleteByPrimaryKey(gId);
		int a = 0;
		if(i>0){
			msg="删除成功！";
			model.addAttribute("msg", msg);
			a = 1;
		}else{
			msg="删除成功！";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
	}

	// 添加商品信息测啊
	@Override
	public int insertSelective(HttpServletRequest request,MultipartFile photo,Goods record,Model model) throws IOException{
			
		   String msg = null;
			//调用上传图片的方法
		   
		   UpPhoto.uppircute(record, photo, request);
		   
	       String status1 = request.getParameter("is_status");
	       
	       if(status1.equals("1")){
	    	   record.setgStatus(1);
	       }else{
	    	   record.setgStatus(2);
	       }
	        
	       String sname1 = request.getParameter("fenlei");
	       
	       for(Sort sort:sortMapper.SelectAll()){
	    	   if(sort.getsName().equals(sname1)){
	    		   record.setsId(sort.getsId());
	    		   break;
	    	   }
	       }
	       
	        record.setgSaledate(new Date());
	        int a = 0;
	        int i = goodsMapper.insertSelective(record);
	        
	        if(i>0){
			msg = "添加成功!";
			model.addAttribute("msg", msg);
			a = 1;
			
		}else{
			msg = "添加失败!";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
 
	}

	// 编辑商品：根据ID查询商品信息
	@Override
	public void selectByPrimaryKey(Integer gId, Model model) {
		Goods goods = goodsMapper.selectByPrimaryKey(gId);
		List<Sort> list = sortMapper.SelectAll();
		String msg = null;

		if (goods != null) {
			Sort sort2 = sortMapper.selectByPrimaryKey(goods.getsId());
			model.addAttribute("goods", goods);
			model.addAttribute("list", list);
			model.addAttribute("sort2", sort2);
		} else {
			msg = "没有改商品信息";
			model.addAttribute("msg", msg);
		}
	}

	// 更新商品信息
	@Override
	public int updateByPrimaryKeySelective(HttpServletRequest request,Goods record,Model model,MultipartFile photo) throws IllegalStateException, IOException {
		
		String msg = null;
		int a = 0;
		
		String status = request.getParameter("is_status");
		
		if(status.equals("1")){
			record.setgStatus(1);
		}else{
			record.setgStatus(2);
		}
		
		String  s= request.getParameter("fenlei");
		
		 for(Sort sort:sortMapper.SelectAll()){
	    	   if(sort.getsName().equals(s)){
	    		   record.setsId(sort.getsId());
	    		   break;
	    	   }
		 }
		 
		 UpPhoto.uppircute(record, photo, request);
		int i = goodsMapper.updateByPrimaryKeySelective(record);
		
		
		if(i>0){
			msg= "更新成功！";
			model.addAttribute("msg", msg);
			a = 1;
		}else{
			msg= "更新失败！";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
	}

	// 用户查看所有商品信息
	@Override
	public List<Goods> findAll(Integer gId) {

		return goodsMapper.findAll(gId);
	}

	// 用户查看单个商品信息
	@Override
	public Goods selectBygId(Integer gId) {

		return goodsMapper.selectBygId(gId);
	}

	@Override
	public int getTotalRecord(Integer sId) throws Exception {

		return goodsMapper.getTotalRecord(sId);
	}

	@Override
	public List<Goods> getByPage(Integer sId, Integer StartIndex, Integer pageSize) throws Exception {

		return goodsMapper.getByPage(sId, StartIndex, pageSize);
	}

	@Override
	public List<Goods> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectlistSort(Model model) {

		List<Sort> sort = goodsMapper.selectlistSort();
		model.addAttribute("sort", sort);
	}

	@Override
	public List<Goods> findParamPage(String gName, Integer pageSize, Integer StartIndex) {
		if (gName != null && gName != "") {
			gName = "%" + gName + "%";
		}
		return goodsMapper.findParamPage(gName, StartIndex, pageSize);
	}

	@Override
	public int findParam(String gName) throws Exception {
		if (gName != null && gName != "") {
			gName = "%" + gName + "%";
		}
		return goodsMapper.findParam(gName);

	}

	//管理员分页以及模糊查询
	@Override
	public void findMyGoods(Model model,Integer pageNumber, Double gSprice, Double gSprice2,String name,String name1) {
		
		List<Sort> listSort2 = sortMapper.SelectAll();
		 model.addAttribute("listSort2", listSort2);
		int currentPage = 1;// 默认页码
		int pageSize = 3;// 默认每页记录数
		if (pageNumber != null) {
			currentPage = pageNumber;
		}
		
		Integer id  = null;
		if(name==null){
			id = listSort2.get(0).getsId();	
		}else{
			for(Sort sort :listSort2){
				if(sort.getsName().equals(name)){
					id = sort.getsId();
					break;
							
				}
			}
		}
		
		Sort sort = sortMapper.selectByPrimaryKey(id);
		model.addAttribute("sort", sort);
		
		Double s = null;
		if(gSprice==null){
			s = gSprice = (double) 0;
		}else{
			s = gSprice;
		}
		
		Double s2 = null;
		if(gSprice2==null){
			s2 = gSprice2 = (double) 99999999;
		}else{
			s2 = gSprice2;
		}
		
		String name2 = null;
		if(name1==null||name1==""){
			name2 = name1 ="%"+""+"%";
		}else{
			name2 = "%"+name1+"%";
		}
		
		PageBean<Goods> goods = new PageBean<>();
		goods.setPageNumber(currentPage);
		goods.setTotalRecord(goodsMapper.getTotalRecord2(id, s, s2, name2));

		goods.setPageSize(pageSize);

		// 调用持久层获取用户所有数据
		List<Goods> list = goodsMapper.findMyGoods(goods.getStartIndex(), pageSize, s, s2, name2, id);
		goods.setData(list);
		model.addAttribute("goods", goods);
		
	}
}
