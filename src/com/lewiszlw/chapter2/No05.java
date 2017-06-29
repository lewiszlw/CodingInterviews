package com.lewiszlw.chapter2;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

/**
 * 面试题5：从尾到头打印链表
 * @author lewiszlw
 *
 */
public class No05 {
	//遍历链表，将每个节点的值放到数组中,然后从尾到头遍历数组并打印
	public void printListReversingly1(ListNode head){
		if(head==null){
			return;
		}
		ArrayList<Integer> arr=new ArrayList<Integer>();
		ListNode p=head;
		while(p!=null){
			arr.add(p.val);
			p=p.next;
		}
		int len=arr.size();
		for(int i=len-1;i>=0;i--){
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}
	
	//反转链表并遍历打印
	public void printListReversingly2(ListNode head){
		if(head==null){
			return;
		}
		if(head.next==null){
			System.out.print(head.val);
			return;
		}
		ListNode pre=head;
		ListNode p=head.next;
		ListNode next=null;
		while(p!=null){
			next=p.next;
			p.next=pre;
			pre=p;
			p=next;
		}
		//去除头结点的环
		head.next=null;
		//反转后的链表头结点
		ListNode newHead=pre;
		ListNode pNode=newHead;
		while(pNode!=null){
			System.out.print(pNode.val+" ");
			pNode=pNode.next;
		}
		System.out.println();
	}
	
	//遍历链表将节点值依次存入栈中
	public void printListReversingly3(ListNode head){
		if(head==null){
			return;
		}
		Stack<Integer> stack=new Stack<>();
		ListNode p=head;
		while(p!=null){
			stack.push(p.val);
			p=p.next;
		}
		while(!stack.isEmpty()){
			System.out.print(stack.pop()+" ");
		}
		System.out.println();
	}

	
	@Test
	public void test1(){
		int[] arr1={1,2,4,5,7,9};
		int[] arr2={};
		int[] arr3={1};
		ListNode head1=ListNode.arrayToList(arr1);
		printListReversingly1(head1);
		ListNode head2=ListNode.arrayToList(arr2);
		printListReversingly1(head2);
		ListNode head3=ListNode.arrayToList(arr3);
		printListReversingly1(head3);
	}
	@Test
	public void test2(){
		int[] arr1={1,2,4,5,7,9};
		int[] arr2={};
		int[] arr3={1};
		ListNode head1=ListNode.arrayToList(arr1);
		printListReversingly2(head1);
		ListNode head2=ListNode.arrayToList(arr2);
		printListReversingly2(head2);
		ListNode head3=ListNode.arrayToList(arr3);
		printListReversingly2(head3);
	}
	@Test
	public void test3(){
		int[] arr1={1,2,4,5,7,9};
		int[] arr2={};
		int[] arr3={1};
		ListNode head1=ListNode.arrayToList(arr1);
		printListReversingly3(head1);
		ListNode head2=ListNode.arrayToList(arr2);
		printListReversingly3(head2);
		ListNode head3=ListNode.arrayToList(arr3);
		printListReversingly3(head3);
	}
	
	
	
	@Test
	public void testListNode(){
		int[] arr={1,2,4,5,7,9};
		ListNode head=ListNode.arrayToList(arr);
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