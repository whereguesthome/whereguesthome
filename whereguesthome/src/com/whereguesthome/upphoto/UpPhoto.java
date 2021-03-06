package com.whereguesthome.upphoto;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.whereguesthome.pojo.Goods;

public class UpPhoto {

	public static void uppircute(Goods record, MultipartFile photo, HttpServletRequest request)
			throws IllegalStateException, IOException {
		String originalFilename = photo.getOriginalFilename();
		// 上传图片
		if (photo != null && originalFilename != null && originalFilename.length() > 0) {

			// 存储图片的物理路径

			/*
			 * String pic_path
			 * =request.getSession().getServletContext().getRealPath("/")+
			 * "img/";
			 * 
			 * 陈志伟 ：图片路径   D:\\git\\whereguesthome\\whereguesthome\\WebContent\\picture\\
			 * 龚振： 图片路径      C:\\Users\\david\\git\\whereguesthome\\whereguesthome\\WebContent\\picture\\
			 */
			String pic_path = "C:\\Users\\david\\git\\whereguesthome\\whereguesthome\\WebContent\\picture\\";

			// 新的图片名称
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

			// 新图片
			File newFile = new File(pic_path + newFileName);

			// 将内存中的数据写入磁盘
			photo.transferTo(newFile);

			// 将新图片名称写到itemsCustom中
			record.setgPhoto(newFileName);

		}
	}
}
