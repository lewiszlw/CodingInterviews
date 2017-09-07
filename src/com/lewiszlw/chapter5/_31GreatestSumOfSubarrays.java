package com.lewiszlw.chapter5;

import org.junit.Test;

/**
 * 面试题31：连续子数组的最大和
 * @author lewis
 *
 */
public class _31GreatestSumOfSubarrays {
	/*
	 * 解法一：当累加和为非正整数，则舍弃，重新累加
	 */
	public int findGreatestSumOfSubArray1(int[] arr){
		if(arr==null || arr.length==0){
			return -1;
		}
		int sum=0;
		int maxSum=0;
		for(int i=0;i<arr.length;i++){
			sum += arr[i];
			if(sum>maxSum){
				maxSum=sum;
			}
			if(sum<=0){
				sum=0;
			}
		}
		return maxSum;
	}

	/*
	 * 解法二：分治法
	 */
	public int findGreatestSumOfSubArray2(int[] arr, int start, int end){
		if(start==end){
			return arr[start]>0? arr[start]:0;
		}

		int mid=(start+end)/2;

		//1.最大值在左边数组
		int leftMaxSum=findGreatestSumOfSubArray2(arr, start, mid);

		//2.最大值在右边数组
		int rightMaxSum=findGreatestSumOfSubArray2(arr, mid+1, end);

		//3.最大值在左右之间
		int leftBoundSum=0; int leftBoundMaxSum=0;
		for(int i=mid;i>=start;i--){
			leftBoundSum += arr[i];
			if(leftBoundSum>leftBoundMaxSum){
				leftBoundMaxSum=leftBoundSum;
			}
		}
		int rightBoundSum=0; int rightBoundMaxSum=0;
		for(int i=mid+1;i<=end;i++){
			rightBoundSum += arr[i];
			if(rightBoundSum>rightBoundMaxSum){
				rightBoundMaxSum=rightBoundSum;
			}
		}
		int midMaxSum=leftBoundMaxSum+rightBoundMaxSum;
		
		int maxSum;
		if(leftMaxSum>rightMaxSum){
			maxSum = leftMaxSum>midMaxSum? leftMaxSum:midMaxSum;
		}else {
			maxSum = rightMaxSum>midMaxSum? rightMaxSum:midMaxSum;
		}
		return maxSum;
	}
	
	@Test
	public void test(){
		int[] arr={1,-2,3,10,-4,7,2,-5};
		System.out.println(findGreatestSumOfSubArray1(arr));
		System.out.println(findGreatestSumOfSubArray2(arr,0, arr.length-1));
	}
}
