package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	单线程
 *	如果两个线程同时运行到判断instance是否为null的if语句，并且if的确没有创建时，那么两个线程都会创建一个实例，此时就不满足单例模式要求了。
 */
public class _02Singleton1 {

	private _02Singleton1(){}
	
	private static _02Singleton1 instance=null;
	
	public static _02Singleton1 getInstance(){
		if(instance==null){
			return new _02Singleton1();
		}else {
			return instance;
		}
	}
	
}
