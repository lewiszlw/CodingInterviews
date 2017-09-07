package com.lewiszlw.chapter5;

import org.junit.Test;

/**
 * 面试题32：从1到n整数中1出现的次数
 * @author lewis
 *
 */
public class _32NumberOfOne {
	
	/*
	 * 解法一：依次计算每个数中1的个数
	 */
	public int numberOfOneBetweenOneAndN1(int n){
		if(n<1){
			return -1;
		}
		int result=0;
		for(int i=1;i<=n;i++){
			result += numberOfOne(i);
		}
		return result;
	}
	private int numberOfOne(int n){
		int count=0;
		while(n>0){
			if(n%10==1){
				count++;
			}
			n /= 10;
		}
		return count;
	}
	
	/*
	 * 解法二：
	 */
	public int numberOfOneBetweenOneAndN2(int n){
		return 0;
	}
	@Test
	public void test(){
		System.out.println(numberOfOneBetweenOneAndN1(12));
	}
}
