package com.lewiszlw.chapter2;

import org.junit.Test;

/**
 * 面试题8：旋转数组的最小数字
 * @author lewiszlw
 *
 */
public class _08MinNumberInRotatedArray {
	public int findMin(int[] arr){
		int i=0, j=arr.length-1;
		int minIndex=i;		//初始值为i，如果旋转0个，则直接返回第一个
		while(arr[i]>=arr[j]){	//这里arr[i]>arr[j]比i<j好，因为存在旋转0个元素情况
			if(j-i==1){
				minIndex=j;
				break;
			}

			int mid=(i+j)/2;
			//当中间数既和arr[i]相等，也和arr[j]相等，选择顺序查找
			//例如1,0,1,1,1和1,1,1,0,1
			if(arr[mid]==arr[i]&&arr[mid]==arr[j]){
				return minInOrder(arr);
			}

			if(arr[mid]<=arr[j]){
				j=mid;
			}

			if(arr[mid]>arr[i]){
				i=mid;
			}
		}
		return arr[minIndex];
	}
	public int minInOrder(int[] arr){
		int min=arr[0];
		for(int i=1;i<arr.length;i++){
			if(arr[i]<min){
				min=arr[i];
			}
		}
		return min;
	}
	
	@Test
	public void test(){
		int[] arr={3,4,5,1,2};
		int[] arr1={1};
		int[] arr2={1,1};
		int[] arr3={1,0,1,1,1};
		int[] arr4={1,2,3,4,5};
		System.out.println(findMin(arr3));
	}
	
	
	
	
	
	
	
	public void quickSort(int[] arr, int left, int right){
		if(left>=right){
			return;
		}
		int i=left, j=right;
		int key=arr[left];
		while(i<j){
			//从右向左找第一个小于key的值
			while(i<j&&arr[j]>=key){
				j--;
			}
			if(i<j){
				arr[i]=arr[j];
				i++;
			}
			
			//从左向右找第一个大于key的值
			while(i<j&&arr[i]<key){
				i++;
			}
			if(i<j){
				arr[j]=arr[i];
				j--;
			}
		}
		
		//i==j
		arr[i]=key;
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}
	
	@Test
	public void testQuickSort(){
		int[] arr={1,6,9,3,10,2,4,8,6};
		quickSort(arr, 0, 8);
		for(int i:arr){
			System.out.println(i);
		}
	}
}
