package com.lewiszlw.chapter4;

import org.junit.Test;

public class Test_21MinInStack {

	public static void main(String[] args) {
		_21MinInStack stack=new _21MinInStack(10);
		try {
			stack.push(4);
			stack.push(5);
			stack.push(3);
			stack.push(2);
			stack.push(6);
			System.out.println(stack.min());
			System.out.println(stack.pop());
			stack.push(9);
			System.out.println(stack.pop());
			System.out.println(stack.min());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.min());
			stack.push(8);
			System.out.println(stack.pop());
			System.out.println(stack.min());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test(){
		_21MinInStack stack=new _21MinInStack(10);
		stack.push(4);
		stack.push(5);
		stack.push(3);
		try {
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
