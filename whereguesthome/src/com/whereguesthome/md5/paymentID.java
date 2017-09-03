package com.whereguesthome.md5;

public class paymentID {

	public static String getpaymentID() {
		// 生成订单编号
		int r1 = (int) (Math.random() * (10));// 产生2个0-9的随机数
		int r2 = (int) (Math.random() * (10));
		long now = System.currentTimeMillis();// 一个13位的时间戳
		String paymentID = String.valueOf(r1) + String.valueOf(r2) + String.valueOf(now);// 订单ID
		return paymentID;
	}

}
