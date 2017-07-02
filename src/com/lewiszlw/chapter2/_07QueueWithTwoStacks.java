package com.lewiszlw.chapter2;

import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 * @author lewis
 *
 */
public class _07QueueWithTwoStacks {
	public static void main(String[] args) {
		CQueue queue=new CQueue();
		try {
			queue.appendTail(1);
			System.out.println(queue.deleteHead());
			queue.appendTail(2);
			queue.appendTail(3);
			System.out.println(queue.deleteHead());
			System.out.println(queue.deleteHead());
			queue.appendTail(4);
			System.out.println(queue.deleteHead());
			System.out.println(queue.deleteHead());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class CQueue{
	private Stack<Integer> stack1=new Stack<>();
	private Stack<Integer> stack2=new Stack<>();
	public void appendTail(int n){
		stack1.push(n);
	}
	public int deleteHead() throws Exception{
		//如果stack2不为空，此时若将stack1弹出的值压入stack1，则会乱序
		if(!stack2.isEmpty()){
			return stack2.pop();
		}else {
			//如果队列为空，则抛出异常
			if(stack1.size()==0){
				throw new Exception("queue is empty!");
			}
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
			return stack2.pop();
		}
	}
}