package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题12：打印1到最大的n位数
 * 
 * @author lewiszlw 陷阱：数据类型问题，如果n较大，大到long型也会溢出
 */
public class _12PrintOneToMaxOfNDigits {
	public void printOneToMaxOfNDigits(int n) {
		if (n <= 0) {
			return;
		}

		//创建字符数组存储n位数并将其初始化
		char[] number = new char[n];
		for(int i=0;i<number.length;i++){
			number[i]='0';
		}

		//循环加1并打印
		while (!increment(number)) {
			printNumber(number);
		}
	}

	// 字符数组加1
	public boolean increment(char[] number) {
		//溢出标志
		boolean isOverflow = false;
		// 进位
		int nTakeOver = 0;
		int nLength = number.length;

		for (int i = nLength - 1; i >= 0; i--) {
			// 本位的数值加上进位
			int nSum = number[i] - '0' + nTakeOver;
			// 最低位
			if (i == nLength - 1) {
				nSum++;
			}
			if(nSum>=10){
				//最高位
				if(i==0){
					isOverflow=true;
				}else {
					nSum=nSum-10;
					nTakeOver=1;
					number[i]=(char)('0'+nSum);
				}
			}else {
				number[i]=(char)('0'+nSum);
				break;	//无需进位，循环终止
			}
		}
		return isOverflow;
	}

	// 打印字符数组
	//n=3, number={'0','9','8'}需打印98而不是098
	public void printNumber(char[] number) {
		boolean isBeginning0=true;
		for(int i=0;i<number.length;i++){
			if(number[i]!='0'){
				isBeginning0=false;
			}
			if(!isBeginning0){
				System.out.print(number[i]);
			}
		}
		System.out.println();
	}
	
	@Test
	public void testIncrement(){
		char[] num={'8','9','9'};
		char[] num1={'9','9','9'};
		System.out.println(increment(num));
		System.out.println(increment(num1));
	}
	
	@Test
	public void testPrintNumber(){
		char[] num={'8','9','9'};
		char[] num1={'0','9','9'};
		printNumber(num);
		printNumber(num1);
	}
	
	@Test
	public void test(){
/*
		char[] num=new char[6];
		for(int i=0;i<num.length;i++){
			num[i]='0';
		}
		for(char i:num){
			System.out.println(i);
		}
*/
		printOneToMaxOfNDigits(3);
	}
}
