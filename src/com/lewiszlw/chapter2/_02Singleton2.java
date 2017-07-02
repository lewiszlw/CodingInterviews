package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	多线程环境加锁——使用同步方法
 *	缺点：每次通过getInstance得到实例时，都会试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要情况下尽量避免
 */
public class _02Singleton2 {
	
	private _02Singleton2(){}
	
	private static _02Singleton2 instance=null;
	
	public static synchronized _02Singleton2 getInstance(){
		if(instance == null){
			return new _02Singleton2();
		}else {
			return instance;
		}
	}

}
