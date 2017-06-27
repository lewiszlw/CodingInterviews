package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	单线程
 *	如果两个线程同时运行到判断instance是否为null的if语句，并且if的确没有创建时，那么两个线程都会创建一个实例，此时就不满足单例模式要求了。
 */
public class No02_1 {

	private No02_1(){}
	
	private static No02_1 instance=null;
	
	public static No02_1 getInstance(){
		if(instance==null){
			return new No02_1();
		}else {
			return instance;
		}
	}
	
}
