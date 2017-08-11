package com.lewiszlw.chapter4;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Test;

/**
 * 面试题23：从上往下打印二叉树
 * 
 * @author lewiszlw 广度优先遍历
 */
public class _23PrintBTreeFromTopToBottom {

	/*
	 * 递归
	 */
	public void bfs(BinaryTreeNode root, Queue<BinaryTreeNode> queue) {
		//当队列为空时queue.poll()返回null，所以需要判断root是否为空
		if(root!=null){
			System.out.println(root.data);
			if (root.leftChild == null && root.rightChild == null) {
				bfs(queue.poll(), queue);
				return;
			}
			if (root.leftChild != null) {
				queue.add(root.leftChild);
			}
			if (root.rightChild != null) {
				queue.add(root.rightChild);
			}
			bfs(queue.poll(), queue);
		}
	}
	
	/*
	 * 非递归
	 */
	public void bfs(BinaryTreeNode root){
		if(root==null){
			return;
		}
		Queue<BinaryTreeNode> queue=new ArrayBlockingQueue<>(1000);
		queue.add(root);
		while(queue.size()>0){
			BinaryTreeNode node=queue.poll();
			System.out.println(node.data);
			if(node.leftChild!=null){
				queue.add(node.leftChild);
			}
			if(node.rightChild!=null){
				queue.add(node.rightChild);
			}
		}
	}

	@Test
	public void test(){
		BinaryTreeNode node1=new BinaryTreeNode(8);
		BinaryTreeNode node2=new BinaryTreeNode(6);
		BinaryTreeNode node3=new BinaryTreeNode(10);
		BinaryTreeNode node4=new BinaryTreeNode(5);
		BinaryTreeNode node5=new BinaryTreeNode(7);
		BinaryTreeNode node6=new BinaryTreeNode(9);
		BinaryTreeNode node7=new BinaryTreeNode(11);
		node1.leftChild=node2;node1.rightChild=node3;
		node2.leftChild=node4;node2.rightChild=node5;
		node3.leftChild=node6;node3.rightChild=node7;
		
		Queue<BinaryTreeNode> queue=new ArrayBlockingQueue<>(1000);
		bfs(node1, queue);
		System.out.println("=====");
		bfs(node1);
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
	}
}
