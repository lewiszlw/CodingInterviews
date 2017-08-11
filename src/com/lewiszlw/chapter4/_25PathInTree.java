package com.lewiszlw.chapter4;

import java.util.Stack;

import org.junit.Test;


/**
 * 面试题25：二叉树中和为某一值的路径
 * @author lewiszlw
 *
 */
public class _25PathInTree {
	public void findPath(BinaryTreeNode root, int expectedSum, Stack<BinaryTreeNode> path, int currentSum){
		if(root==null){
			return;
		}
		path.push(root);
		currentSum += root.data;
		//如果为叶子节点
		if(root.leftChild==null||root.rightChild==null){
			if(currentSum==expectedSum){
				System.out.println("===================");
				for(BinaryTreeNode each: path){
					System.out.println(each.toString());
				}
			}
		}
		findPath(root.leftChild, expectedSum, path, currentSum);
		findPath(root.rightChild, expectedSum, path, currentSum);
		path.pop();
	}
	
	@Test
	public void test(){
		BinaryTreeNode node1=new BinaryTreeNode(8);
		BinaryTreeNode node2=new BinaryTreeNode(6);
		BinaryTreeNode node3=new BinaryTreeNode(10);
		BinaryTreeNode node4=new BinaryTreeNode(5);
		BinaryTreeNode node5=new BinaryTreeNode(7);
		BinaryTreeNode node6=new BinaryTreeNode(3);
		BinaryTreeNode node7=new BinaryTreeNode(11);
		node1.leftChild=node2;node1.rightChild=node3;
		node2.leftChild=node4;node2.rightChild=node5;
		node3.leftChild=node6;node3.rightChild=node7;
		
		Stack<BinaryTreeNode> path=new Stack<>();
		findPath(node1, 21, path, 0);
		findPath(node1, 14, path, 0);
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
