package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	多线程环境——利用静态内部类
 */
public class No02_5 {
	
	private No02_5(){}
	
	private static No02_5 getInstance(){
		return Singleton.instance;
	}
	
	static class Singleton{
		private Singleton(){}
		private static final No02_5 instance=new No02_5();
	}

}
