package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题11：数值的整数次方
 * 
 * @author lewiszlw
 *
 */
public class _11Power {
	// 未考虑特殊情况
	public double power(double base, int exponent) {
		double result = 1.0;
		for (int i = 0; i < exponent; i++) {
			result = result * base;
		}
		return result;
	}

	// 指数为负，底数为0
	// 采用全局变量标识是否出错
	boolean g_InvalidInput = false;

	public double power1(double base, int exponent) {
		// 初始化
		g_InvalidInput = false;
		// 指数为负，底数为0
		if (equal(base, 0.0) && exponent < 0) {
			g_InvalidInput = true;
			return 0;
		}
		int absExponent=Math.abs(exponent);
		double absResult=power(base, absExponent);
		double result;
		if(exponent<0){
			result=1.0/absResult;
		}else {
			result=absResult;
		}
		return result;
	}
	//比较两个浮点型不能直接用==
	public boolean equal(double num1, double num2){
		if((num1-num2)>-0.0000001&&(num1-num2)<0.0000001){
			return true;
		}else {
			return false;
		}
	}

	//优化：用快速幂提高乘方效率，用位运算提高乘除法效率 
	public double power2(double base, int exponent){
		if(exponent==0){
			return 1;
		}
		if(exponent==1){
			return base;
		}
		//递归调用
		double result=power2(base, exponent>>1);
		result *=result;
		//如果指数为奇数，需要再乘一次base
		if((exponent&0x1)==1){
			result*=base;
		}
		return result;
	}
	
	@Test
	public void test() {
		System.out.println(power(2.0, 2));
		System.out.println(power1(0, -1));
		System.out.println(power1(2.0, -2));
		System.out.println(power2(2.0, 32));
		System.out.println(5&0x1);
		System.out.println(121&0x1);
		System.out.println(10&0x1);
	}
}
