package com.lewiszlw.chapter2;

import org.junit.Test;

/**
 * 面试题3：二维数组中的查找
 * 
 * @author lewiszlw
 *
 */
public class No03 {
	public boolean find(int[][] arr, int num) {
		if (arr == null) {
			return false;
		}
		int rows = arr.length; // 行数
		int columns = arr[0].length; // 列数
		int i = 0, j = columns - 1; // 二维数组最右上角
		while (i < rows && j >= 0) {
			int target = arr[i][j];
			if (target == num) {
				return true;
			}
			//当最右上角数大于所查数，删除最右列
			if (target > num) {
				j--;
			}
			//当最右上角数小于所查数，删除最上列
			if (target < num) {
				i++;
			}
		}
		return false;
	}

	@Test
	public void test() {
		int[][] arr1 = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		int[][] arr2=null;
		System.out.println(find(arr1, 7));
	}
}
