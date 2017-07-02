package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	单线程
 *	缺点是该类加载的时候就会直接new 一个静态对象出来，当系统中这样的类较多时，会使得启动速度变慢
 */
public class _02Singleton3 {
	
	private _02Singleton3(){}
	
	private static _02Singleton3 instance=new _02Singleton3();
	
	public static _02Singleton3 getInstance(){
		return instance;
	}

}
