package com.lewiszlw.chapter4;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * 面试题26：复杂链表的复制
 * @author lewiszlw
 *在复杂链表中，每个节点除了有一个next指针指向下一个节点外，还有一个sibling指针
 *指向链表中的任意节点或者null。
 */
public class _26CopyComplexList {
	/*
	 * 哈希表
	 */
	public ComplexListNode clone(ComplexListNode head){
		if(head==null){
			return null;
		}
		//key为N'，value为N
		Map<ComplexListNode, ComplexListNode> map1=new HashMap<>();
		//key为N，value为N'
		Map<ComplexListNode, ComplexListNode> map2=new HashMap<>();

		ComplexListNode p1=head;
		//第一步，复制原链表每一个节点，并用next连接
		ComplexListNode node=new ComplexListNode(0);
		ComplexListNode preHead=node;
		while(p1!=null){
			ComplexListNode cloneNode=new ComplexListNode(p1.val);
			map1.put(cloneNode, p1);
			map2.put(p1, cloneNode);
			node.next=cloneNode;
			node=cloneNode;
			p1=p1.next;
		}

		//第二步，设置每个节点的sibling
		ComplexListNode p2=preHead.next;	//新复杂链表头结点
		while(p2!=null){
			ComplexListNode sNode=map1.get(p2);	//新节点复制的源节点
			p2.sibling=map2.get(sNode.sibling);
			p2=p2.next;
		}
		
		return preHead.next;
	}
	
	

	/*
	 * 每个节点后面跟上复制的节点
	 * A -> B -> C
	 * A -> A' -> B -> B' -> C -> C'
	 */
	public ComplexListNode clone1(ComplexListNode head){
		if(head==null){
			return null;
		}
		//第一步：根据原始链表每个结点N创建对应的N'
		cloneNodes(head);

		//第二步：设置复制出来的结点的sibling
		connectSiblingNodes(head);
		
		//第三步：将长链表拆分成两个链表
		return reconnectNodes(head);
	}
	public void cloneNodes(ComplexListNode head){
		ComplexListNode p=head;
		while(p!=null){
			ComplexListNode next=p.next;
			ComplexListNode node=new ComplexListNode(p.val);
			p.next=node;
			node.next=next;
			p=next;
		}
	}
	public void connectSiblingNodes(ComplexListNode head){
		ComplexListNode p=head;
		int count=0;
		while(p!=null){
			//每隔一个判断
			if(p.sibling!=null && (count&1)==0){
				p.next.sibling=p.sibling.next;
			}
			p=p.next;
			count++;
		}
	}
	public ComplexListNode reconnectNodes(ComplexListNode head){
		ComplexListNode newHead=head.next;
		ComplexListNode pre=head;
		ComplexListNode p=pre.next;
		while(p!=null){
			pre.next=p.next;
			pre=p;
			p=p.next;
		}
		return newHead;
	}
	

	
	

	@Test
	public void test(){
		ComplexListNode node1=new ComplexListNode(1);
		ComplexListNode node2=new ComplexListNode(2);
		ComplexListNode node3=new ComplexListNode(3);
		ComplexListNode node4=new ComplexListNode(4);
		ComplexListNode node5=new ComplexListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node1.sibling=node3;
		node2.sibling=node5;
		node4.sibling=node2;
		
		ComplexListNode head=clone(node1);
//		ComplexListNode head=clone1(node1);
		System.out.println(head.val);
		System.out.println(head.next.val);
		System.out.println(head.next.next.val);
		System.out.println(head.next.next.next.val);
		System.out.println(head.next.next.next.next.val);
		System.out.println("====");
		System.out.println(head.sibling.val);
		System.out.println(head.next.sibling.val);
		System.out.println(head.next.next.next.sibling.val);
	}
	
	
	
	
	
	
	
	/**
	 * 复制链表结点类
	 * @author lewiszlw
	 */
	class ComplexListNode{
		int val;
		ComplexListNode next;
		ComplexListNode sibling;

		public ComplexListNode(int val){
			this.val=val;
		}
		public ComplexListNode(int val, ComplexListNode next, ComplexListNode sibling){
			this.val=val;
			this.next=next;
			this.sibling=sibling;
		}
	}
}
