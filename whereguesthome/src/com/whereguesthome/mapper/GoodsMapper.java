package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.whereguesthome.pojo.Goods;
import com.whereguesthome.pojo.Sort;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
public interface GoodsMapper {
	

	//根据ID删除商品信息
    int deleteByPrimaryKey(Integer gId);

    //插入商品信息
    int insertSelective(Goods record);

    //根据ID查询商品信息
    Goods selectByPrimaryKey(Integer gId);

    //更新商品信息
    int updateByPrimaryKeySelective(Goods record);

    //查询所有的商品信息
    @Select("select g_id gId,g_name gName,g_price gPrice,g_saleprice gSaleprice,g_describes gDescribes,"
    		+ "g_contents gContents,g_photo gPhoto,g_repertory gRepertory,g_saledate gSaledate,"
    		+ "s_id sId,g_status gStatus from goods")
    List<Goods> selectAll();
    
    
  //根据商品分类s_id查询所以信息
    @Select("select g_id gId,g_name gName,g_price gPrice,g_saleprice gSaleprice,g_describes gDescribes,g_contents gContents,g_photo gPhoto,g_repertory gRepertory,g_saledate gSaledate,s_id sId from goods where s_id =#{sId}")
    List<Goods> findAll(@Param("sId")Integer  sId);
      
    //根据商品g_id查询单个商品的所有信息
    @Select("select g_id gId,g_name gName,g_price gPrice,g_saleprice gSaleprice,g_describes gDescribes,g_contents gContents,g_photo gPhoto,g_repertory gRepertory,g_saledate gSaledate,s_id sId from goods where g_id =#{gId}")
    Goods selectBygId(@Param("gId")Integer gId);
    	
   int getTotalRecord(@Param("sId") Integer sId);
	
	List<Goods> getByPage(@Param("sId") Integer sId,@Param("StartIndex")Integer StartIndex,			
			@Param("pageSize")Integer pageSize);
	
	List<Sort> selectlistSort();

	//根据商品的名称查询记录总数
	int findParam(@Param("gName") String gName);
	//模糊查询分页
	List<Goods> findParamPage(@Param("gName") String gName,@Param("StartIndex")Integer StartIndex,@Param("pageSize")Integer pageSize);
		
}