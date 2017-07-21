package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题15：链表中倒数第k个结点
 * @author lewiszlw
 *	链表从1开始计数
 */
public class _15KthNodeFromEnd {
	//计算出顺数第几个
	public ListNode findKthToTail(ListNode head, int k){
		if(head==null||k<=0){
			return null;
		}
		int len=getLengthOfList(head);
		int index=len-k+1;
		ListNode p=head;
		for(int i=1;i<index;i++){
			p=p.next;
		}
		return p;
	}
	public int getLengthOfList(ListNode head){
		int len=0;
		ListNode p=head;
		while(p!=null){
			len++;
			p=p.next;
		}
		return len;
	}
	
	@Test
	public void test(){
		int[] arr={1,2,3,4,5,6};
		ListNode head=ListNode.arrayToList(arr);
		System.out.println(findKthToTail(head, 3).val);
	}

}

