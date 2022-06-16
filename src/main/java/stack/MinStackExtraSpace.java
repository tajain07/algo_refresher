package stack;

import java.util.Stack;

/**
 * https://youtu.be/asf9P2Rcopo
 * <p>
 * https://leetcode.com/problems/min-stack/
 */
public class MinStackExtraSpace {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public static void main(String[] args) {
        MinStackExtraSpace minStack = new MinStackExtraSpace();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        final int min1 = minStack.getMin();// return -3
        minStack.pop();
        final int top = minStack.top();// return 0
        final int min2 = minStack.getMin();// return -2
    }


    public MinStackExtraSpace() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        if (minStack.isEmpty() || minStack.peek() >= val)
            minStack.push(val);
        stack.push(val);
    }

    public void pop() {

        if (!stack.isEmpty()) {
            if (minStack.peek().equals(stack.peek()))
                minStack.pop();
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return Integer.MIN_VALUE; //this value can be changed as per the problem constraint
        return minStack.peek();
    }
}
