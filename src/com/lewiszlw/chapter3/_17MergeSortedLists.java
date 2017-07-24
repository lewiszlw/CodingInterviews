package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题17：合并两个排序的链表
 * @author lewiszlw
 *
 */
public class _17MergeSortedLists {
	/*
	 * 合并两个排序链表到一个新链表
	 */
	public ListNode merge(ListNode head1, ListNode head2){
		ListNode newHead=new ListNode(0);
		ListNode p1=head1;
		ListNode p2=head2;
		ListNode p=newHead;
		ListNode node;

		//两个链表相同部分
		while(p1!=null&&p2!=null){
			if(p1.val<p2.val){
				node=new ListNode(p1.val);
				p.next=node;
				p=node;
				p1=p1.next;
			}else {
				node=new ListNode(p2.val);
				p.next=node;
				p=node;
				p2=p2.next;
			}
		}
		//如果第一个链表有多余部分
		while(p1!=null){
			node=new ListNode(p1.val);
			p.next=node;
			p=node;
			p1=p1.next;
		}
		//如果第二个链表有多余部分
		while(p2!=null){
			node=new ListNode(p2.val);
			p.next=node;
			p=node;
			p2=p2.next;
		}
		return newHead.next;
	}
	
	/*
	 * 直接在两个链表上操作
	 */
	public ListNode merge1(ListNode head1, ListNode head2){
		if(head1==null){
			return head2;
		}
		if(head2==null){
			return head1;
		}
		ListNode head=head1.val<head2.val?head1:head2;
		ListNode p1=head1;
		ListNode p2=head2;
		ListNode p1Next;
		ListNode p2Next;
		while(p1!=null && p2!=null){
			p1Next=p1.next;
			p2Next=p2.next;
			if(p1.val<p2.val){
				p1.next=p2;
				p1=p1Next;
			}else {
				p2.next=p1;
				p2=p2Next;
			}
		}
		return head;
	}
	
	@Test
	public void test(){
//		int[] arr1={1,3,5,7};
		int[] arr1={};
//		int[] arr2={2,4,6,8};
		int[] arr2={};
		ListNode head1=ListNode.arrayToList(arr1);
		ListNode head2=ListNode.arrayToList(arr2);
//		ListNode head=merge(head1, head2);
		ListNode head=merge1(head1, head2);
		ListNode.printList(head);
	}
}
