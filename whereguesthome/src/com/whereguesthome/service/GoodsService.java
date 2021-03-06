package com.whereguesthome.service;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import com.whereguesthome.pojo.Goods;

public interface GoodsService {

	// 根据ID删除商品信息
	int deleteByPrimaryKey(Integer gId, Model model);

	// 插入商品信息
	int insertSelective(HttpServletRequest request, MultipartFile photo, Goods record, Model model) throws IOException;

	// 根据ID查询商品信息
	void selectByPrimaryKey(Integer gId, Model model);

	// 更新商品信息
	int updateByPrimaryKeySelective(HttpServletRequest request, Goods record, Model model, MultipartFile photo)
			throws IllegalStateException, IOException;

	// 查询所有的商品信息
	void selectAll(Model model);

	List<Goods> selectAll();

	// 用户查看所有商品信息
	List<Goods> findAll(Integer sId);
	// 用户查看单个商品信息

	Goods selectBygId(Integer gId);

	// 根据商品类型s_Id查询记录总数
	int getTotalRecord(Integer sId) throws Exception;

	/**
	 * 根据商品类型sId进行分页
	 * 
	 * @param tid
	 *            商品类型id
	 * @param StartIndex
	 *            开始索引
	 * @param pageSize
	 *            每页记录数
	 * @return
	 * @throws Exception
	 */
	List<Goods> getByPage(Integer sId, Integer StartIndex, Integer pageSize) throws Exception;

	void selectlistSort(Model model);

	// 根据商品的名称查询记录总数
	int findParam(String gName) throws Exception;

	// 根据商品名称模糊查询
	List<Goods> findParamPage(String gName, Integer pageSize, Integer StartIndex);

	//管理员的分页以及模糊查询
	void findMyGoods(Model model,Integer pageNumber, Double gSprice, Double gSprice2,String name,String name1);
}
