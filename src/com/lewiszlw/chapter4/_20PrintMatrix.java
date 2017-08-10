package com.lewiszlw.chapter4;

import org.junit.Test;

/**
 * 面试题20：顺时针打印矩阵
 * @author lewiszlw
 *
 */
public class _20PrintMatrix {
	/**
	 * @param numbers	矩阵
	 * @param rowIndex	起始行
	 * @param colIndex	起始列
	 */
	public void printMatrixClockwisely(int[][] numbers, int rowIndex, int colIndex){
		if(numbers==null||numbers.length==0){
			return;
		}
		//数组只有一个元素
		if(numbers.length==1 && numbers[0].length==1){
			System.out.println(numbers[0][0]);
			return;
		}

		int i=colIndex, j=rowIndex;
		//上横行
		for(;i<numbers[0].length-colIndex-1;i++){
			System.out.println(numbers[j][i]);
			//System.out.println("j:"+j+", i:"+i);
		}
		//右竖行
		for(;j<numbers.length-rowIndex-1;j++){
			System.out.println(numbers[j][i]);
		}
		//下横行
		for(;i>colIndex;i--){
			System.out.println(numbers[j][i]);
		}
		//左竖行
		for(;j>rowIndex;j--){
			System.out.println(numbers[j][i]);
		}	
		if(rowIndex>numbers.length/2||colIndex>numbers[0].length/2){
			return;
		}
		printMatrixClockwisely(numbers, rowIndex+1, colIndex+1);
	}
	
	
	/**
	 * 例如：
	 * 1, 2, 3, 4
	 * 5, 6, 7, 8
	 * 9, 10,11,12
	 * 13,14,15,16
	 * 打印顺序：
	 * 1,2,3
	 * 4,8,12
	 * 16,15,14
	 * 13,9,5
	 * ......
	 */
	@Test
	public void test(){
		int[][] arr={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}
		};
		int[][] arr1={
				{1,2,3},
				{5,6,7},
				{9,10,11},
				{13,14,15}
		};
		int[][] arr2={{1}};
		int[][] arr3={{1,2}};
		int[][] arr4={{1},{2}};
		int[][] arr5={
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
		};
		printMatrixClockwisely(arr5, 0, 0);
	}
}
