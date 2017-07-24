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
		if(k>len){
			return null;
		}
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
	
	//双指针间隔k-1
	public ListNode findKthToTail1(ListNode head, int k){
		if(head==null||k<=0){
			return null;
		}
		
		//初始化两个相隔k-1的指针，注意长度不足k
		ListNode p1=head;
		for(int i=0;i<k;i++){
			if(p1!=null){
				p1=p1.next;
			}else {
				return null;
			}
		}
		ListNode p2=head;
		
		while(p1!=null){
			p1=p1.next;
			p2=p2.next;
		}
		return p2;
	}
	
	@Test
	public void test(){
		int[] arr={1,2,3,4,5,6};
		ListNode head=ListNode.arrayToList(arr);
		System.out.println(findKthToTail(head, 3).val);
		System.out.println(findKthToTail(head, -1));
		System.out.println(findKthToTail(head, 7));
		System.out.println(findKthToTail1(head, 3).val);
		System.out.println(findKthToTail1(head, -1));
		System.out.println(findKthToTail1(head, 7));
	}

}

