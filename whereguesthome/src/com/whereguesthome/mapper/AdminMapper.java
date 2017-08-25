package com.whereguesthome.mapper;

import com.whereguesthome.pojo.Admin;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
public interface AdminMapper {
    
    Admin selectByNmae(String aName);

}