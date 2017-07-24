package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题16：反转链表
 * @author lewiszlw
 *
 */
public class _16ReverseList {

	//三指针
	public ListNode reverseList(ListNode head){
		if(head==null||head.next==null){
			return head;
		}

		ListNode pre=head;
		ListNode p=pre.next;
		ListNode next;
		while(p!=null){
			next=p.next;
			p.next=pre;
			pre=p;
			p=next;
		}

		//去除头结点的环
		head.next=null;

		return pre;
	}
	
	@Test
	public void test(){
		int[] arr1={1,2,3,4,5};
		ListNode head1=ListNode.arrayToList(arr1);
		ListNode newHead1=reverseList(head1);
		ListNode.printList(newHead1);
		int[] arr2={1};
		ListNode head2=ListNode.arrayToList(arr2);
		ListNode newHead2=reverseList(head2);
		ListNode.printList(newHead2);
		int[] arr3={};
		ListNode head3=ListNode.arrayToList(arr3);
		ListNode newHead3=reverseList(head3);
		ListNode.printList(newHead3);
	}
}
