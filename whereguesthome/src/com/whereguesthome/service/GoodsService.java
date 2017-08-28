package com.whereguesthome.service;
import java.util.List;

import org.springframework.ui.Model;

import com.whereguesthome.pojo.Goods;

public interface GoodsService {
	    
	//根据ID删除商品信息
    int deleteByPrimaryKey(Integer gId,Model model);

    //插入商品信息
    int insertSelective(Goods record,Model model);

    //根据ID查询商品信息
    void selectByPrimaryKey(Integer gId,Model model);

    //更新商品信息
    int updateByPrimaryKeySelective(Goods record,Model model);

    //查询所有的商品信息
    void selectAll(Model model);

    List<Goods> selectAll();
    
	//用户查看所有商品信息
    List<Goods> findAll(Integer sId);
 	//用户查看单个商品信息
    
 	Goods selectBygId(Integer gId);

	 //根据商品类型s_Id查询记录总数	
	int getTotalRecord(Integer sId)throws Exception;
	/**
	 * 根据商品类型sId进行分页
	 * @param tid 商品类型id
	 * @param StartIndex 开始索引
	 * @param pageSize	每页记录数
	 * @return
	 * @throws Exception
	 */
	List<Goods> getByPage(Integer sId, Integer StartIndex, Integer pageSize) throws Exception;
}
