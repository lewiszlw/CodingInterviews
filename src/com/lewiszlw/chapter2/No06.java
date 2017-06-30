package com.lewiszlw.chapter2;

import org.junit.Test;

/**
 * 面试题6：重建二叉树
 * @author lewiszlw
 *	不含重复数字
 */
public class No06 {
	public BinaryTreeNode constructTree(int[] preOrder, int[] inOrder){
		if(preOrder==null||inOrder==null){
			return null;
		}
		//根节点
		BinaryTreeNode root=new BinaryTreeNode(preOrder[0]);

		//左子树节点个数
		int leftChildNum=0;
		for(int i=0;i<inOrder.length;i++){
			if(inOrder[i]==root.val){
				break;
			}else {
				leftChildNum++;
			}
		}
		//右子树节点个数
		int rightChildNum=inOrder.length-leftChildNum-1;

		//如果左子树存在
		if(leftChildNum>0){
			//左子树前序遍历结果
			int[] leftPreOrder=new int[leftChildNum];
			//左子树中序遍历结果
			int[] leftInOrder=new int[leftChildNum];
			for(int i=0;i<leftChildNum;i++){
				leftPreOrder[i]=preOrder[i+1];
				leftInOrder[i]=inOrder[i];
			}

			//左子树根节点
			BinaryTreeNode leftRoot=constructTree(leftPreOrder, leftInOrder);

			root.leftChild=leftRoot;
		}
		
		//如果右子树存在
		if(rightChildNum>0){
			//右子树前序遍历结果
			int[] rightPreOrder=new int[rightChildNum];
			//右子树中序遍历结果
			int[] rightInOrder=new int[rightChildNum];
			for(int i=0;i<rightChildNum;i++){
				rightPreOrder[i]=preOrder[1+leftChildNum+i];
				rightInOrder[i]=inOrder[1+leftChildNum+i];
			}
			
			//右子树根节点
			BinaryTreeNode rightRoot=constructTree(rightPreOrder, rightInOrder);

			root.rightChild=rightRoot;
		}
		return root;
	}
	
	@Test
	public void test(){
		int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		BinaryTreeNode root=constructTree(preOrder, inOrder);
		BinaryTreeNode.printPostOrder(root);
	}

}

class BinaryTreeNode{
	int val;
	BinaryTreeNode leftChild;
	BinaryTreeNode rightChild;

	public BinaryTreeNode(int val){
		this.val=val;
	}
	public BinaryTreeNode(int val, BinaryTreeNode leftChild, BinaryTreeNode rightChild){
		this.val=val;
		this.leftChild=leftChild;
		this.rightChild=rightChild;
	}
	
	//前序遍历
	public static void printPreOrder(BinaryTreeNode root){
		if(root==null){
			return;
		}
		System.out.print(root.val+" ");
		printPreOrder(root.leftChild);
		printPreOrder(root.rightChild);
	}
	
	//中序遍历
	public static void printInOrder(BinaryTreeNode root){
		if(root==null){
			return;
		}
		printInOrder(root.leftChild);
		System.out.print(root.val+" ");
		printInOrder(root.rightChild);
	}
	
	//后序遍历
	public static void printPostOrder(BinaryTreeNode root){
		if(root==null){
			return;
		}
		printPostOrder(root.leftChild);
		printPostOrder(root.rightChild);
		System.out.print(root.val+" ");
	}
}











