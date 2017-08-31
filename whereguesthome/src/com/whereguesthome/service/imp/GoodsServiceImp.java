package com.whereguesthome.service.imp;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import com.whereguesthome.mapper.GoodsMapper;
import com.whereguesthome.mapper.SortMapper;
import com.whereguesthome.pojo.Goods;
import com.whereguesthome.pojo.PageBean;
import com.whereguesthome.pojo.Sort;
import com.whereguesthome.service.GoodsService;
import com.whereguesthome.upphoto.UpPhoto;

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
	public int deleteByPrimaryKey(Integer gId, Model model) {
		String msg = null;
		int i = goodsMapper.deleteByPrimaryKey(gId);
		int a = 0;
		if (i > 0) {
			msg = "删除成功！";
			model.addAttribute("msg", msg);
			a = 1;
		} else {
			msg = "删除成功！";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
	}

	// 添加商品信息测啊
	@Override
	public int insertSelective(HttpServletRequest request, MultipartFile photo, Goods record, Model model)
			throws IOException {

		String msg = null;
		// 调用上传图片的方法

		UpPhoto.uppircute(record, photo, request);

		String status1 = request.getParameter("is_status");
		System.out.println("---------------------状态---------" + status1);

		if (status1.equals("1")) {
			record.setgStatus(1);
		} else {
			record.setgStatus(2);
		}

		String sname1 = request.getParameter("fenlei");

		System.out.println("----------分类的名字---------" + sname1);
		for (Sort sort : sortMapper.SelectAll()) {
			if (sort.getsName().equals(sname1)) {
				record.setsId(sort.getsId());
				break;
			}
		}

		record.setgSaledate(new Date());
		int a = 0;
		int i = goodsMapper.insertSelective(record);

		if (i > 0) {
			msg = "添加成功!";
			model.addAttribute("msg", msg);
			a = 1;

		} else {
			msg = "添加失败!";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;

	}

	// 编辑商品：根据ID查询商品信息
	@Override
	public void selectByPrimaryKey(Integer gId, Model model) {
		Goods goods = goodsMapper.selectByPrimaryKey(gId);
		List<Sort> list = sortMapper.SelectAll();
		String msg = null;

		if (goods != null) {
			Sort sort2 = sortMapper.selectByPrimaryKey(goods.getsId());
			model.addAttribute("goods", goods);
			model.addAttribute("list", list);
			model.addAttribute("sort2", sort2);
		} else {
			msg = "没有改商品信息";
			model.addAttribute("msg", msg);
		}
	}

	// 更新商品信息
	@Override
	public int updateByPrimaryKeySelective(HttpServletRequest request, Goods record, Model model, MultipartFile photo)
			throws IllegalStateException, IOException {

		String msg = null;
		int a = 0;

		String status = request.getParameter("is_status");

		if (status.equals("1")) {
			record.setgStatus(1);
		} else {
			record.setgStatus(2);
		}

		String s = request.getParameter("fenlei");

		for (Sort sort : sortMapper.SelectAll()) {
			if (sort.getsName().equals(s)) {
				record.setsId(sort.getsId());
				break;
			}
		}

		UpPhoto.uppircute(record, photo, request);
		int i = goodsMapper.updateByPrimaryKeySelective(record);

		if (i > 0) {
			msg = "更新成功！";
			model.addAttribute("msg", msg);
			a = 1;
		} else {
			msg = "更新失败！";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
	}

	// 用户查看所有商品信息
	@Override
	public List<Goods> findAll(Integer gId) {

		return goodsMapper.findAll(gId);
	}

	// 用户查看单个商品信息
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

	@Override
	public void selectlistSort(Model model) {

		List<Sort> sort = goodsMapper.selectlistSort();
		model.addAttribute("sort", sort);
	}

	@Override
	public List<Goods> findParamPage(String gName, Integer pageSize, Integer StartIndex) {
		if (gName != null && gName != "") {
			gName = "%" + gName + "%";
		}
		return goodsMapper.findParamPage(gName, StartIndex, pageSize);
	}

	@Override
	public int findParam(String gName) throws Exception {
		if (gName != null && gName != "") {
			gName = "%" + gName + "%";
		}
		return goodsMapper.findParam(gName);

	}

}
