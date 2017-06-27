package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	单线程
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
