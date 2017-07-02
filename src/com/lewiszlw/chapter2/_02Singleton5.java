package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	多线程环境——利用静态内部类
 */
public class _02Singleton5 {
	
	private _02Singleton5(){}
	
	private static _02Singleton5 getInstance(){
		return Singleton.instance;
	}
	
	static class Singleton{
		private Singleton(){}
		private static final _02Singleton5 instance=new _02Singleton5();
	}

}
