package com.yibazhang.consumer.utils;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * @author jared
 * 
 * @Description:id生成工具
 * 
 * @date Nov 5, 2014 6:14:29 PM
 * 
 */
public class IdUtils {
	private static final int BASE = 100000;
	private static Random RANDOM = new Random(System.currentTimeMillis());
	private static AtomicInteger serial = new AtomicInteger(BASE);

	/**
	 * 根据当前时间生成随机id
	 *
	 * @return long类型id
	 */
	public static long make() {
		return timeToId(System.currentTimeMillis());
	}

	/**
	 * 通过时间生成随机id
	 *
	 * @param timeInMillis
	 * @return
	 */
	public static long timeToId(long timeInMillis) {
		if (serial.intValue() > 9900 * BASE) {
			serial.set(BASE);
		}
		return timeInMillis / 1000 * 1000000000 + serial.getAndAdd(BASE) + RANDOM.nextInt(BASE);
	}

	public static void main(String[] args) {
//		DecimalFormat df = new DecimalFormat(",###.##");
//		System.out.println(df.format(98980123.3));
		System.out.println(make());
		System.out.println("--------------------------");
		System.out.println(timeToId(System.currentTimeMillis()));
		System.out.println("--------------------------");
		System.out.println(UUID.randomUUID()+"_第一章作业.txt");
	}
}
