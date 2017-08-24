package com.whereguesthome.mapper;

import com.whereguesthome.pojo.Sort;

public interface SortMapper {
    int deleteByPrimaryKey(Integer sId);

    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Integer sId);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
}