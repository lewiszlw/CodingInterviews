package com.lewiszlw.chapter4;

import org.junit.Test;

/**
 * 面试题24：二叉搜索树的后序遍历序列
 * 
 * @author lewiszlw 
 * 假设输入数组的数互不相同 
 * 例如：5, 7, 6, 9, 11, 10, 8 
 * 根节点是8 
 * 5, 7, 6是左子树（均小于根节点） 
 * 9, 11, 10是右子树（均大于根节点）
 */
public class _24SequenceOfBST {
	public boolean verifySequenceOfBST(int sequence[], int start, int end) {
		if (sequence == null || sequence.length == 0) {
			return false;
		}

		if (start >= end) {
			return true;
		}

		// 根节点
		int root = sequence[end];

		// 左子树
		int i = start;
		for (; i < end; i++) {
			if (sequence[i] > root) {
				break;
			}
		}

		// 右子树
		int j = i;
		for (; j < end; j++) {
			if (sequence[j] < root) {
				return false;
			}
		}

		return verifySequenceOfBST(sequence, start, i - 1) && verifySequenceOfBST(sequence, i, end - 1);
	}

	@Test
	public void test() {
		int[] seq = { 5, 7, 6, 9, 11, 10, 8 };
		int[] seq1 = { 7, 4, 6, 5 };
		int[] seq2 = { 1 };
		int[] seq3 = null;
		System.out.println(verifySequenceOfBST(seq, 0, seq.length-1));
		System.out.println(verifySequenceOfBST(seq1, 0, seq1.length-1));
		System.out.println(verifySequenceOfBST(seq2, 0, seq2.length-1));
		System.out.println(verifySequenceOfBST(seq3, 0, 0));
	}
}
