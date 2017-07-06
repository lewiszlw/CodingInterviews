package com.lewiszlw.chapter2;

import org.junit.Test;

/**
 * 面试题9：斐波那契数列
 * @author lewiszlw
 *
 */
public class _09Fibonacci {
	//数值：0,1,1,2,3,5,8,13
	//索引：0,1,2,3,4,5,6,7

	//递归
	public long fibonacci1(int n){
		if(n<=0){return 0;}
		if(n==1){return 1;}
		return fibonacci1(n-1)+fibonacci1(n-2);
	}
	
	//循环,临时变量和result记录三个相邻值
	public long fibonacci2(int n){
		if(n<=0){return 0;}
		if(n==1){return 1;}
		long result=0;
		long a=0, b=1;
		for(int i=1;i<n;i++){
			result=a+b;
			a=b;
			b=result;
		}
		return result;
	}
	
	//矩阵法
	public long fibonacci3(int n){
		if(n<=0){return 0;}
		if(n==1){return 1;}
		long[][] res={{1,1},{1,0}};
		long[][] matrix={{1,1},{1,0}};
		for(int i=1;i<n-1;i++){
			res=matrixMultiply(res, matrix);
		}
		return res[0][0];
	}
	//矩阵相乘(行列相同)
	public long[][] matrixMultiply(long[][] a, long[][] b){
		//矩阵行和列长度
		int len=a.length;
		long[][] result=new long[len][len];
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				for(int k=0;k<len;k++){
					result[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		return result;
	}
	
	
	@Test
	public void test(){
		System.out.println(fibonacci2(100));
		System.out.println(fibonacci3(100));
		
		/*
		int[][] a={{1,1},{1,0}};
		int[][] b={{1,1},{1,0}};
		int[][] result=matrixMultiply(a, b);
		for(int i=0;i<result.length;i++){
			for(int j=0;j<result[i].length;j++){
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
		*/
	}
	
	
	
	/**
	 * 一只青蛙一次可以跳1级台阶，也可以跳2级。求该青蛙跳上一个n级的台阶总共多少种跳法?
	 * 分析：把n阶台阶的跳法看成n的函数，记为f(n)。当n>2时，第一次跳的时候就有两种不同的选择：一是第一次只跳1级，此时跳法数目
	 * 等于后面剩下的n-1阶台阶的跳法数目，即为f(n-1)；另外一种选择是第一次跳2级，此时跳法数目等于后面剩下的n-2级台阶的跳法数
	 * 目，即为f(n-2)。因此n级台阶的不同跳法的总数f(n)=f(n-1)+f(n-2)。
	 * @param n
	 */
	public int jump(int n){
		if(n<1){
			return 0;
		}
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		return jump(n-1)+jump(n-2);
	}
	
	@Test
	public void testJump(){
		System.out.println(jump(4));
	}
}
