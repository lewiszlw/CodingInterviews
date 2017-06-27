package com.lewiszlw.chapter2;

/**
 * 面试题2：实现单例模式
 * @author lewiszlw
 *	单线程
 *	缺点是该类加载的时候就会直接new 一个静态对象出来，当系统中这样的类较多时，会使得启动速度变慢
 */
public class No02_3 {
	
	private No02_3(){}
	
	private static No02_3 instance=new No02_3();
	
	public static No02_3 getInstance(){
		return instance;
	}

}
