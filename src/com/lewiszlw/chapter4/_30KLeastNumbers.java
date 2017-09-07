package com.lewiszlw.chapter4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

import org.junit.Test;

/**
 * 面试题30：最小的k个数
 * @author lewiszlw
 *
 */
public class _30KLeastNumbers {
	
	/*
	 * 解法一：基于快排
	 */
	public int[] getLeastNumbers1(int[] input, int k){
		if(input==null || input.length==0 || input.length<k){
			return null;
		}
		int start=0, end=input.length-1;
		int index=partition(input, start, end);
		while(index != k-1){
			if(index>k-1){
				end=index-1;
				index=partition(input, start, end);
			}
			if(index<k-1){
				start=index+1;
				index=partition(input, start, end);
			}
		}
		return Arrays.copyOf(input, k);
	}
	private int partition(int[] num, int start, int end){
		int key=num[start];
		int i=start, j=end;
		while(i<j){
			while(i<j && num[j]>=key){
				j--;
			}
			if(i<j){
				num[i]=num[j];
			}
			while(i<j && num[i]<key){
				i++;
			}
			if(i<j){
				num[j]=num[i];
			}
		}
		num[i]=key;
		return i;
	}
	
	/*
	 * 解法二：最大堆。适合海量数据
	 */
	public int[] getLeastNumbers2(int[] input, int k){
		if(input==null || input.length==0 || input.length<k){
			return null;
		}
		//大小为k的最大堆（PriorityQueue默认较小优先）
		PriorityQueue<Integer> queue=new PriorityQueue<>(k, comparator);
		for(int i=0;i<input.length;i++){
			if(queue.size()<k){
				queue.add(input[i]);
			}else {
				if(input[i]<queue.peek()){
					queue.poll();
					queue.add(input[i]);
				}
			}
		}
		int[] result=new int[k];
		int index=k-1;
		for(Iterator<Integer> iter=queue.iterator(); iter.hasNext();){
			result[index]=iter.next();
			index--;
		}
		return result;
	}
	private Comparator<Integer> comparator=new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2-o1;
		}
	};
	
	@Test
	public void test(){
		int[] input={1,5,2,4,9,7,4,6,3,7,0,2};
		int[] result=getLeastNumbers2(input, 5);
		System.out.println(Arrays.toString(result));
	}
}
