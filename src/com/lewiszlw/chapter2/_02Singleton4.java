package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	多线程环境
 *	缺点：每次通过getInstance得到实例时，都会试图加上一个同步锁，而加锁是一个非常耗时的操作，在没有必要情况下尽量避免
 */
public class _02Singleton4 {
	
	private _02Singleton4(){}
	
	private static volatile _02Singleton4 instance=null;
	
	public static _02Singleton4 getInstance(){
		if(instance==null){
			synchronized (_02Singleton4.class) {
				instance=new _02Singleton4();
			}
		}
		return instance;
	}

}
