package com.lewiszlw.chapter2;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 面试题7：用两个栈实现队列
 * @author lewis
 *
 */
public class _07QueueWithTwoStacks {
	public static void main(String[] args) {
		CQueue queue=new CQueue();
		CStack stack=new CStack();
		try {
//			queue.appendTail(1);
//			System.out.println(queue.deleteHead());
//			queue.appendTail(2);
//			queue.appendTail(3);
//			System.out.println(queue.deleteHead());
//			System.out.println(queue.deleteHead());
//			queue.appendTail(4);
//			System.out.println(queue.deleteHead());
//			System.out.println(queue.deleteHead());
			
			stack.push(1);
			System.out.println(stack.pop());
			stack.push(2);
			stack.push(3);
			System.out.println(stack.pop());
			stack.push(4);
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
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

/**
 * 相关：两个队列实现一个栈
 * @author lewis
 *
 */
class CStack{
	private Queue<Integer> queue1=new ArrayDeque<>();
	private Queue<Integer> queue2=new ArrayDeque<>();

	public void push(int n){
		if(!queue1.isEmpty()){
			queue1.add(n);
		}else {
			queue2.add(n);
		}
	}
	
	public int pop() throws Exception{
		if(queue1.size()==0&&queue2.size()==0){
			throw new Exception("Stack is empty!");
		}
		if(!queue1.isEmpty()){
			while(queue1.size()>1){
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}else {
			while(queue2.size()>1){
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}
	}
}