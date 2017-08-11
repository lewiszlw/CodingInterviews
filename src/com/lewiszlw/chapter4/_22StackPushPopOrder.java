package com.lewiszlw.chapter4;

import org.junit.Test;

/**
 * 面试题22：栈的压入、弹出序列
 * @author lewiszlw 
 * 使用辅助栈判断
 */
public class _22StackPushPopOrder {
	public boolean isPopOrder(int[] pushOrder, int[] popOrder) throws Exception {
		if (pushOrder == null || popOrder == null || pushOrder.length == 0 || popOrder.length == 0) {
			return false;
		}
		_21MinInStack stack = new _21MinInStack(pushOrder.length);
		int i = 0, j = 0;
		while (i < pushOrder.length) {
			// 栈顶元素
			int head = pushOrder[i];
			//判断j是否超出是防止出入栈序列不等长
			while (j < popOrder.length && head == popOrder[j]) {
				j++;
				if (stack.isEmpty()) {
					break;
				} else {
					head = stack.pop();
				}
			}
			// 如果出栈序列全部已判断正确，返回true
			if (j == popOrder.length) {
				return true;
			}

			// 不相等则将弹出的栈顶元素压入栈中
			if (head != popOrder[j]) {
				stack.push(head);
			}

			i++;
		}
		return false;
	}

	@Test
	public void test() {
		int[] pushOrder = { 1, 2, 3, 4, 5 };
		int[] popOrder1 = { 4, 5, 3, 2, 1 };
		int[] popOrder2 = { 4, 3, 5, 1, 2 };
		int[] popOrder3 = { 4, 3, 5 };
		int[] popOrder4 = { 4, 3, 5, 2, 1, 0 };
		try {
			System.out.println(isPopOrder(pushOrder, popOrder1));
			System.out.println(isPopOrder(pushOrder, popOrder2));
			System.out.println(isPopOrder(pushOrder, popOrder3));
			System.out.println(isPopOrder(pushOrder, popOrder4));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
