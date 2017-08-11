package com.lewiszlw.chapter4;

/**
 * 面试题21：包含min函数的栈
 * @author lewiszlw
 * 
 * 如果使用成员变量包含最小值，那当最小值弹出栈后，当前栈的最小值变化，而无法更新成员变量（无法简易获取次小值） 
 * java无法创造泛型数组
 */
public class _21MinInStack {
	// 栈
	private int[] stack;
	// 辅助栈
	private int[] minStack;
	// 默认容量为10
	private final static int DEFAULT_CAPACITY = 10;
	// 栈指针
	private int head;
	// 栈大小
	private int size;

	public _21MinInStack() {
		this.stack = new int[DEFAULT_CAPACITY];
		this.minStack = new int[DEFAULT_CAPACITY];
		this.size = 0;
		this.head = 0;
	}

	public _21MinInStack(int capacity) {
		this.stack = new int[capacity];
		this.minStack = new int[capacity];
		this.size = 0;
		this.head = 0;
	}

	/*
	 * 入栈
	 */
	public void push(int val) {
		if (!isFull()) {
			stack[head] = val;
			if (minStack == null || size == 0) {
				minStack[head] = val;
			} else if (size > 0) {
				if (val < minStack[head - 1]) {
					minStack[head] = val;
				} else {
					minStack[head] = minStack[head - 1];
				}
			}
			size++;
			head++;
		} else {
			resize();
			push(val);
		}
	}

	/*
	 * 出栈
	 */
	public int pop() throws Exception {
		if (!isEmpty()) {
			head--;
			size--;
			return stack[head];
		} else {
			throw new Exception("栈为空");
		}
	}

	/*
	 * 返回当前栈中的最小值
	 */
	public int min() throws Exception {
		if (size == 0 || minStack == null) {
			throw new Exception("栈为空");
		} else {
			return minStack[head - 1];
		}
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean isFull() {
		return size == stack.length;
	}

	public int size() {
		return size;
	}

	private void resize() {
		int newLen = stack.length * 2;
		int[] tempStack = new int[newLen];
		int[] tempMinStack = new int[newLen];
		for (int i = 0; i < stack.length; i++) {
			tempStack[i] = stack[i];
			tempMinStack[i] = minStack[i];
		}
		stack = tempStack;
		minStack = tempMinStack;
	}
}
