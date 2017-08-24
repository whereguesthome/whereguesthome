package com.whereguesthome.controller.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * <p>
 * Title: CustomDateConverter
 * </p>
 * <p>
 * Description:����ת����
 * </p>
 * <p>
 * Company: www.itcast.com
 * </p>
 */
public class CustomDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {

		// ʵ�� �����ڴ�ת����������(��ʽ��yyyy-MM-dd HH:mm:ss)

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			// ת��ֱ�ӷ���
			return simpleDateFormat.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ���������ʧ�ܷ���null
		return null;
	}

}
