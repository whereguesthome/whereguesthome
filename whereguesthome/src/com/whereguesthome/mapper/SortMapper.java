package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.whereguesthome.pojo.Sort;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
public interface SortMapper {
	
	//根据ID删除分类表信息
    int deleteByPrimaryKey(Integer sId);

    //添加分类信息
    int insertSelective(Sort record);

    //根据ID查询分类信息
    Sort selectByPrimaryKey(Integer sId);

    //更新分类信息
    int updateByPrimaryKeySelective(Sort record);
    
    //查询所有的分类信息
    @Select("select s_id sId,s_name sName from sort")
    List<Sort> SelectAll();
    
    //查询所以信息
    @Select("select s_id sId,s_name sName from sort")
    List<Sort> findAll();

}