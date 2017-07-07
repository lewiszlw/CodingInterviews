package com.lewiszlw.chapter2;

import org.junit.Test;

/**
 * 面试题10：二进制中1的个数
 * @author lewiszlw
 *
 */
public class _10NumberOfOneInBinary {
	//左移n，比较最低位
	public int numberOfOne(int n){
		n=Math.abs(n);
		int count=0;
		while(n!=0){
			if((n&1)==1){
				count++;
			}
			n=n>>1;
		}
		return count;
	}
	
	//左移flag，依次比较n的最低位、次地位...是否为1
	//1<<32为1  1<<31为-2147483648  1<<30为1073741824
	public int numberOfOne1(int n){
		int count=0;
		int flag=1;
		while(flag<(1<<30)){
			if((n&flag)==flag){
				count++;
			}
			flag=(flag<<1);
		}
		return count;
	}

	//例如1100(2)，减一后为1011(2)，与本身1100(2)做与运算得到1000(2)
	public int numberOfOne2(int n){
		n=Math.abs(n);
		int count=0;
		while(n!=0){
			count++;
			n=(n-1)&n;
		}
		return count;
	}

	
	@Test
	public void test(){
//		System.out.println(numberOfOne(0));
//		System.out.println(numberOfOne(9));
//		System.out.println(numberOfOne(-1));
//		System.out.println(numberOfOne1(0));
//		System.out.println(numberOfOne1(9));
//		System.out.println(numberOfOne1(-1));
//		System.out.println(1<<30);
		System.out.println(numberOfOne2(0));
		System.out.println(numberOfOne2(9));
		System.out.println(numberOfOne2(-1));
	}
}
