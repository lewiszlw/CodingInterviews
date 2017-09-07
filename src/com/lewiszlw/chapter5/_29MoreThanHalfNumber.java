package com.lewiszlw.chapter5;

import java.util.Arrays;

import org.junit.Test;

/**
 * 面试题29：数组中出现次数超过一半的数字
 * @author lewiszlw
 *
 */
public class _29MoreThanHalfNumber {

	/*
	 * 解法一：排序，取中间值
	 */
	public int moreThanHalfNum1(int[] numbers){
		if(numbers==null || numbers.length==0){
			return -1;
		}
		Arrays.sort(numbers);
		return numbers[numbers.length >> 1];
	}
	
	/*
	 * 解法二：遍历，统计数字出现次数，大于数组长度一半则返回
	 */
	public int moreThanHalfNum2(int[] numbers){
		if(numbers==null || numbers.length==0){
			return -1;
		}
		Arrays.sort(numbers);
		int count=1;
		int temp=numbers[0];
		for(int i=1;i<numbers.length;i++){
			if(numbers[i]==temp){
				count++;
			}else {
				if(count>numbers.length >> 1){
					return temp;
				}else {
					count=1;
					temp=numbers[i];
				}
			}
		}
		if(count>numbers.length >> 1){	//可能顺序执行下来
			return temp;
		}else {
			return -1;
		}
	}
	
	/*
	 * 解法三：基于快排
	 */
	public int moreThanHalfNum3(int[] numbers){
		if(numbers==null || numbers.length==0){
			return -1;
		}
		int mid = numbers.length >> 1;
		int start=0, end=numbers.length-1;
		int index=partition(numbers, start, end);
		while(index != mid){
			if(index>mid){
				end=index-1;
				index=partition(numbers, start, end);
			}
			if(index<mid){
				start=index+1;
				index=partition(numbers, start, end);
			}
		}
		return numbers[mid];	//mid=index
	}
	private int partition(int[] numbers, int start, int end){
		int key=numbers[start];
		int i=start, j=end;
		while(i<j){
			while(i<j && numbers[j]>=key){
				j--;
			}
			if(i<j){
				numbers[i]=numbers[j];
			}
			while(i<j && numbers[i]<key){
				i++;
			}
			if(i<j){
				numbers[j]=numbers[i];
			}
		}
		numbers[i]=key;
		return i;
	}
	
	/*
	 * 解法四：保存数字和次数，若下一个数字相同则次数加1，若下一个数字不同则次数减1，若次数为0，则保存下一个数字，并将次数设为1。
	 * 那么要找的数字肯定是最后一次把次数设为1时的对应的数字。
	 */
	public int moreThanHalfNum4(int[] numbers){
		if(numbers==null || numbers.length==0){
			return -1;
		}
		int count=1;
		int temp=numbers[0];
		for(int i=1;i<numbers.length;i++){
			if(numbers[i]==temp){
				count++;
			}else {
				count--;
			}
			if(count==0){
				count=1;
				temp=numbers[i];
			}
		}
		return temp;
	}
	
	@Test
	public void test(){
		int[] arr={1,2,3,3,5,5,5,5,5};
		System.out.println(moreThanHalfNum1(arr));
		System.out.println(moreThanHalfNum2(arr));
		System.out.println(moreThanHalfNum3(arr));
		System.out.println(moreThanHalfNum4(arr));
	}
}
