package com.whereguesthome.service;
import java.util.List;

import org.springframework.ui.Model;
import com.whereguesthome.pojo.Sort;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
public interface SortService {

	//根据ID删除分类表信息
    int deleteByPrimaryKey(Integer sId,Model model);

    //添加分类信息
    boolean insertSelective(Sort record,Model model);

    //根据ID查询分类信息
    void selectByPrimaryKey(Integer sId,Model model);

    //更新分类信息
    int updateByPrimaryKeySelective(Sort record,Model model);
    
    //查询所有的分类信息
    void SelectAll(Model model);
    
   //用户查看所以商品分类信息
	List<Sort> findAll();

	String findJosn() throws Exception;
}
