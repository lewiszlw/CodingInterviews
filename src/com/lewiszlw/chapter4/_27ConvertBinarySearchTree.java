package com.lewiszlw.chapter4;


import org.junit.Test;

/**
 * 面试题27：二叉搜索树与双向链表
 * @author lewiszlw
 * 二叉搜索树中序遍历就是有序序列
 */
public class _27ConvertBinarySearchTree {
	
	/*
	 * 运用中序遍历特点
	 */
	public BinaryTreeNode convert(BinaryTreeNode root){
		if(root==null){
			return null;
		}
		BinaryTreeNode lastNodeOfList=null;
		lastNodeOfList=convertNode(root, lastNodeOfList);

		//反向遍历获取双向链表头结点
		BinaryTreeNode p=lastNodeOfList;
		System.out.println(p);
		while(p.leftChild!=null){
			p=p.leftChild;
		}
		return p;
	}
	public BinaryTreeNode convertNode(BinaryTreeNode root, BinaryTreeNode lastNodeOfList){
		if(root==null){
			return null;
		}
		if(root.leftChild!=null){
			lastNodeOfList=convertNode(root.leftChild, lastNodeOfList);
		}

		//当前节点（root）的左孩子指向左子树的最后遍历的一个节点（lastNodeOfList）
		root.leftChild=lastNodeOfList;
		//同时双向链表的另一方向指向下一节点
		if(lastNodeOfList!=null){
			lastNodeOfList.rightChild=root;
		}
		//此时链表最后一个节点变为root
		lastNodeOfList=root;

		if(root.rightChild!=null){
			lastNodeOfList=convertNode(root.rightChild, lastNodeOfList);
		}
		return lastNodeOfList;
	}
	
	
	@Test
	public void test(){
		BinaryTreeNode node4=new BinaryTreeNode(4);
		BinaryTreeNode node5=new BinaryTreeNode(8);
		BinaryTreeNode node6=new BinaryTreeNode(12);
		BinaryTreeNode node7=new BinaryTreeNode(16);
		BinaryTreeNode node2=new BinaryTreeNode(6, node4, node5);
		BinaryTreeNode node3=new BinaryTreeNode(14, node6, node7);
		BinaryTreeNode node1=new BinaryTreeNode(10, node2, node3);
		
		BinaryTreeNode head=convert(node1);
		BinaryTreeNode p=head;
		while(p!=null){
			System.out.println(p.data);
			p=p.rightChild;
		}
	}
	
	
	
	
	
	
	
	/**
	 * 二叉树结点
	 * @author lewiszlw
	 */
	class BinaryTreeNode {
		int data;
		BinaryTreeNode leftChild;
		BinaryTreeNode rightChild;

		public BinaryTreeNode(int data) {
			this.data = data;
		}

		public BinaryTreeNode(int data, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
			this.data = data;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
		public String toString(){
			return "[ val = "+data+" ]";
		}
	}
}
