package com.whereguesthome.service.imp;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import com.whereguesthome.mapper.GoodsMapper;
import com.whereguesthome.mapper.SortMapper;
import com.whereguesthome.pojo.Goods;

import com.whereguesthome.pojo.GoodsSort;
import com.whereguesthome.pojo.PageBean;

import com.whereguesthome.pojo.Sort;
import com.whereguesthome.service.GoodsService;

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
			String originalFilename = photo.getOriginalFilename();  
	        //上传图片  
	        if(photo!=null && originalFilename!=null && originalFilename.length()>0){   
	       
	        //存储图片的物理路径  
	        String pic_path =request.getSession().getServletContext().getRealPath("/")+ "img/";

	        System.out.println("lujing+++++++++"+pic_path);
	        
	        //新的图片名称  
	        String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));  
	        
	        //新图片  
	        File newFile = new File(pic_path+newFileName);  
	        
	        //将内存中的数据写入磁盘  
	        photo.transferTo(newFile);    
	        
	        //将新图片名称写到itemsCustom中  
	        record.setgPhoto(newFileName);
	              
	        }  
	       String status1 = request.getParameter("is_status");
	       System.out.println("---------------------状态---------"+status1);
	       
	       if(status1.equals("1")){
	    	   record.setgStatus(1);
	       }else{
	    	   record.setgStatus(2);
	       }
	        
	       String sname1 = request.getParameter("fenlei");
	       
	       System.out.println("----------分类的名字---------"+sname1);
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

	// 根据ID查询商品信息
	@Override
	public void selectByPrimaryKey(Integer gId,Model model) {
		Goods goods = goodsMapper.selectByPrimaryKey(gId);
		List<Sort> list = sortMapper.SelectAll();
		String msg = null;
		
		if(goods!=null){
			Sort sort2 = sortMapper.selectByPrimaryKey(goods.getsId());
			model.addAttribute("goods", goods);
			model.addAttribute("list", list);
			model.addAttribute("sort2", sort2);
		}else{
			msg = "没有改商品信息";
			model.addAttribute("msg", msg);
		}
	}

	// 根据ID更新商品信息
	@Override
	public int updateByPrimaryKeySelective(Goods record,Model model) {
		String msg = null;
		int a = 0;
		
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
   
	//用户查看所有商品信息
	@Override
	public List<Goods> findAll(Integer  gId) {		
		
		return goodsMapper.findAll(gId);
	}
	
	//用户查看单个商品信息
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
    
	//模糊查询
	@Override
	public void findParam(String gName ,Model m) {
		if(gName !=null && gName !=""){
			gName="%"+gName+"%";
		}
     List<Goods> list=goodsMapper.findParam(gName);		
     m.addAttribute("list", list);
	}

	@Override
	public void selectlistSort(Model model) {
		
		List<Sort> sort = goodsMapper.selectlistSort();
		model.addAttribute("sort", sort);
	}

	public void findParamPage(Model m,Integer pageNumber) {
	  int currentPage = 1;//默认页码
		int pageSize = 4;//默认每页记录数	
		if (pageNumber != null) {
			currentPage = pageNumber;
		}
		//总记录数
		List<Goods> list=goodsMapper.selectAll();
		int totalRecord=list.size();
		PageBean<Goods> pagebean=new PageBean<>();
		pagebean.setPageNumber(currentPage);
		pagebean.setPageSize(pageSize);
		pagebean.setTotalPage(totalRecord);
		
		List<Goods> listGoods=goodsMapper.findParamPage(pagebean.getStartIndex(), pageNumber);
		pagebean.setData(listGoods);
		m.addAttribute("pagebean", "pagebean");
	}

	
	
	}


