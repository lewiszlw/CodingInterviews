package com.lewiszlw.chapter4;

import org.junit.Test;

/**
 * 面试题19：二叉树的镜像
 * @author lewiszlw
 *
 */
public class _19MirrorOfBinaryTree {
	public void mirrorRecursively(BinaryTreeNode root){
		if(root==null){
			return;
		}
		BinaryTreeNode temp=root.leftChild;
		root.leftChild=root.rightChild;
		root.rightChild=temp;
		mirrorRecursively(root.leftChild);
		mirrorRecursively(root.rightChild);
	}
	
	@Test
	public void test(){
		BinaryTreeNode node1=new BinaryTreeNode(8);
		BinaryTreeNode node2=new BinaryTreeNode(6);
		BinaryTreeNode node3=new BinaryTreeNode(10);
		BinaryTreeNode node4=new BinaryTreeNode(5);
		BinaryTreeNode node5=new BinaryTreeNode(7);
		BinaryTreeNode node6=new BinaryTreeNode(9);
//		BinaryTreeNode node7=new BinaryTreeNode(11);
		node1.leftChild=node2;node1.rightChild=node3;
		node2.leftChild=node4;node2.rightChild=node5;
		node3.leftChild=node6;//node3.rightChild=node7;
		
		mirrorRecursively(node1);
		node1.preOrder(node1);
	}
}



/**
 * 二叉树结点
 * @author lewiszlw
 */
class BinaryTreeNode{
	int val;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;
	
	public BinaryTreeNode(){}
	public BinaryTreeNode(int val){
		this.val=val;
	}
	public BinaryTreeNode(int val, BinaryTreeNode leftChild, BinaryTreeNode rightChild){
		this.val=val;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}
	
	/*
	 * 前序遍历：根左右
	 */
	public void preOrder(BinaryTreeNode root){
		if(root==null){
			return;
		}
		System.out.println(root.val);
		preOrder(root.leftChild);
		preOrder(root.rightChild);
	}
	
	/*
	 * 中序遍历：左根右
	 */
	public void inOrder(BinaryTreeNode root){
		if(root==null){
			return;
		}
		preOrder(root.leftChild);
		System.out.println(root.val);
		preOrder(root.rightChild);
	}
	
	/*
	 * 后序遍历：左右根
	 */
	public void postOrder(BinaryTreeNode root){
		if(root==null){
			return;
		}
		preOrder(root.leftChild);
		preOrder(root.rightChild);
		System.out.println(root.val);
	}
}