package com.whereguesthome.mapper;

import com.whereguesthome.pojo.Address;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
}