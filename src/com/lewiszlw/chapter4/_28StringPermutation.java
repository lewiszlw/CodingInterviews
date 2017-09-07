package com.lewiszlw.chapter4;

import java.util.Arrays;

import org.junit.Test;

/**
 * 面试题28：字符串的排列
 * 
 * @author lewiszlw 将字符串看成第一个字符和后面字符两部分，将第一个字符和后面所有字符交换，递归调用求后面字符。
 */
public class _28StringPermutation {
	public void permutation(String str) {
		if (str == null || str.equals("")) {
			return;
		}
		char[] c = str.toCharArray();
		permutation(c, 0);
	}

	private void permutation(char[] c, int begin) {
		if (begin == c.length - 1) {
			System.out.println(new String(c));
		} else {
			for (int i = begin; i < c.length; i++) {
				if (i>begin && c[begin] == c[i]) { // 相同则不交换
					continue;
				}
				char[] copy = Arrays.copyOf(c, c.length);
				char temp = copy[begin];
				copy[begin] = copy[i];
				copy[i] = temp;
				permutation(copy, begin + 1);
			}
		}
	}

	@Test
	public void test() {
		permutation("abc");
		System.out.println("====");
		permutation("aba");
		System.out.println("====");
		permutation("");
		System.out.println("====");
		permutation(null);
	}

}
