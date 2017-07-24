package com.lewiszlw.chapter3;

import org.junit.Test;

/**
 * 面试题18：树的子结构
 * @author lewiszlw
 *	判断二叉树B是不是二叉树A的子结构
 */
public class _18SubstructureInTree {

	/**
	 * 在树A中查找与B树根节点的值一样的结点
	 * @param rootA	树A的根节点
	 * @param rootB	树B的根节点
	 * @return
	 */
	public boolean hasSubtree(BinaryTreeNode rootA, BinaryTreeNode rootB){
		boolean result=false;
		if(rootA!=null && rootB!=null){
			if(rootA.val==rootB.val){
				result=doesTreeAhaveTreeB(rootA, rootB);
			}
			if(!result){
				result=hasSubtree(rootA.leftChild, rootB);
			}
			if(!result){
				result=hasSubtree(rootA.rightChild, rootB);
			}
		}
		return result;
	}
	
	/**
	 * 判断是否具有相同结构
	 * @param rootA
	 * @param rootB
	 * @return
	 */
	public boolean doesTreeAhaveTreeB(BinaryTreeNode rootA, BinaryTreeNode rootB){
		//注意递归终止条件的顺序
		if(rootB==null){
			return true;
		}
		if(rootA==null){
			return false;
		}
		if(rootA.val!=rootB.val){
			return false;
		}
		return doesTreeAhaveTreeB(rootA.leftChild, rootB.leftChild) && doesTreeAhaveTreeB(rootA.rightChild, rootB.rightChild);
	}
	
	@Test
	public void test(){
		BinaryTreeNode Bnode1=new BinaryTreeNode(8);
		BinaryTreeNode Bnode2=new BinaryTreeNode(8);
		BinaryTreeNode Bnode3=new BinaryTreeNode(7);
		BinaryTreeNode Bnode4=new BinaryTreeNode(9);
		BinaryTreeNode Bnode5=new BinaryTreeNode(2);
		BinaryTreeNode Bnode6=new BinaryTreeNode(4);
		BinaryTreeNode Bnode7=new BinaryTreeNode(7);
		Bnode1.leftChild=Bnode2;Bnode1.rightChild=Bnode3;
		Bnode2.leftChild=Bnode4;Bnode2.rightChild=Bnode5;
		Bnode5.leftChild=Bnode6;Bnode5.rightChild=Bnode7;
		
		BinaryTreeNode Anode1=new BinaryTreeNode(8);
		BinaryTreeNode Anode2=new BinaryTreeNode(9);
		BinaryTreeNode Anode3=new BinaryTreeNode(2);
		Anode1.leftChild=Anode2;Anode1.rightChild=Anode3;
		
		System.out.println(hasSubtree(Bnode1, Anode1));
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