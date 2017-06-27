package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	多线程环境
 *	缺点：每次通过getInstance得到实例时，都会试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要情况下尽量避免
 */
public class No02_4 {
	
	private No02_4(){}
	
	private static volatile No02_4 instance=null;
	
	public static No02_4 getInstance(){
		if(instance==null){
			synchronized (No02_4.class) {
				instance=new No02_4();
			}
		}
		return instance;
	}

}
