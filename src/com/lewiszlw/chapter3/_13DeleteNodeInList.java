package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题13：在O(1)时间删除链表结点
 * @author lewiszlw
 *	三种情况：
 *		1.头结点；
 *		2.中间结点；
 *		3.尾结点。
 */
public class _13DeleteNodeInList {

	/**
	 * 常规O(n)解法
	 * @param head
	 * @param target
	 * @return
	 */
	public ListNode deleteNode(ListNode head, ListNode target){
		if(head==null){
			return null;
		}
		if(target==null){
			return head;
		}

		ListNode p=head;

		//第一种情况：删除头结点
		if(target==head){
			return target.next;
		}

		//找到target结点上一个结点
		while(p.next!=target){
			p=p.next;
		}

		//第二种情况：删除尾结点
		if(target.next==null){
			p.next=null;
			return head;
		}else {
			//第三种情况：删除中间结点
			p.next=target.next;
			target.next=null;
			return head;
		}
	}
	
	
	/**
	 * O(1)解法
	 * 将target下一节点值赋给target节点，删除target节点
	 * @param head
	 * @param target
	 * @return
	 */
	public ListNode deleteNode1(ListNode head, ListNode target){
		if(head==null){
			return null;
		}
		if(target==null){
			return head;
		}
		
		//第一种情况：删除头结点
		if(target==head){
			return target.next;
		}
		
		//第二种情况：删除尾结点
		if(target.next==null){
			ListNode p=head;
			while(p.next!=target){
				p=p.next;
			}
			p.next=null;
			return head;
		}else {
			//第三种情况：删除中间结点
			target.val=target.next.val;
			target.next=target.next.next;
			return head;
		}
	}
	
	@Test
	public void testDeleteNode(){
		ListNode p0=new ListNode(0);
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		ListNode p3=new ListNode(3);
		ListNode p4=new ListNode(4);
		p0.next=p1;p1.next=p2;p2.next=p3;p3.next=p4;
//		ListNode head=deleteNode(p0, p0);
//		ListNode head=deleteNode(p0, p2);
		ListNode head=deleteNode(p0, p4);
		ListNode.printList(head);
	}
	
	@Test
	public void testDeleteNode1(){
		ListNode p0=new ListNode(0);
		ListNode p1=new ListNode(1);
		ListNode p2=new ListNode(2);
		ListNode p3=new ListNode(3);
		ListNode p4=new ListNode(4);
		p0.next=p1;p1.next=p2;p2.next=p3;p3.next=p4;
//		ListNode head=deleteNode1(p0, p0);
//		ListNode head=deleteNode1(p0, p2);
		ListNode head=deleteNode1(p0, p4);
		ListNode.printList(head);
	}
}

class ListNode{
	int val;
	ListNode next;

	public ListNode(int val){
		this.val=val;
	}
	public ListNode(int val, ListNode next){
		this.val=val;
		this.next=next;
	}

	public static ListNode arrayToList(int[] arr){
		ListNode head=new ListNode(0);
		ListNode p=head;
		ListNode node=null;
		for(int val: arr){
			node=new ListNode(val);
			p.next=node;
			p=p.next;
		}
		return head.next;
	}
	
	public static void printList(ListNode head){
		ListNode p=head;
		while(p!=null){
			System.out.print(p.val+" ");
			p=p.next;
		}
		System.out.println();
	}
}