package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	多线程环境加锁——使用同步方法
 *	缺点：每次通过getInstance得到实例时，都会试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要情况下尽量避免
 */
public class No02_2 {
	
	private No02_2(){}
	
	private static No02_2 instance=null;
	
	public static synchronized No02_2 getInstance(){
		if(instance == null){
			return new No02_2();
		}else {
			return instance;
		}
	}

}
