package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题14：调整数组顺序使奇数位于偶数前面
 * @author lewiszlw
 */
public class _14ReorderArray {
	//双指针
	public void reorderOddEven(int[] arr){
		if(arr==null||arr.length==0||arr.length==1){
			return;
		}
		int i=0,j=arr.length-1;
		while(i<=j){
			//循环直至指针i指向一个偶数
			while(i<=j&&((arr[i]&1)==0)){
				i++;
			}
			//循环直至指针j指向一个奇数
			while(i<=j&&((arr[j]&1)==1)){
				j--;
			}
			//交换指针i所指的偶数和指针j所指的奇数
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}
	}
	
	//可扩展性的解法
	public void reorder(int[] arr){
		if(arr==null||arr.length==0||arr.length==1){
			return;
		}
		int i=0,j=arr.length-1;
		while(i<=j){
			//循环直至指针i所指不满足函数isEven
			while(i<=j&&(!isEven(arr[i]))){
				i++;
			}
			//循环直至指针j所指满足函数isEven
			while(i<=j&&isEven(arr[j])){
				j--;
			}
			//交换指针i所指的数和指针j所指的数
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}

	}
	public boolean isEven(int n){
		return (n&1)==1;
	}
	
	@Test
	public void test(){
		int[] arr={1,2,3,4,5,6};
//		reorderOddEven(arr);
		reorder(arr);
		for(int i:arr){
			System.out.println(i);
		}
		
	}
}
