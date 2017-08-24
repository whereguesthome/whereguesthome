package com.whereguesthome.mapper;

import com.whereguesthome.pojo.Items;

public interface ItemsMapper {
    int insert(Items record);

    int insertSelective(Items record);
}