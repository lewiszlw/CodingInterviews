package com.lewiszlw.chapter3;

/**
 * 面试题12：打印1到最大的n位数
 * @author lewiszlw
 *	陷阱：数据类型问题，如果n较大，大到long型也会溢出
 */
public class _12PrintOneToMaxOfNDigits {
	public void printOneToMaxOfNDigits(int n){
		if(n<=0){
			return;
		}
		char[] number=new char[n];
		while(!increment(number)){
			printNumber(number);
		}
	}
	//字符数组加1
	public boolean increment(char[] number){
		boolean isOverflow=false;
		return false;
	}
	//打印字符数组
	public void printNumber(char[] number){
		
	}
}
