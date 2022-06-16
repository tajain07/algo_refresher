package stack;

import java.util.Stack;

/**
 * https://youtu.be/ZvaRHYYI0-4
 * <p>
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 *
 * Some testcase failing -- revisit
 */
public class MinStackNoExtraSpace {

    Stack<Integer> stack;
    Integer minElement = null;

    public static void main(String[] args) {
        MinStackNoExtraSpace minStack = new MinStackNoExtraSpace();
        minStack.push(2147483646);
        minStack.push(2147483646);
        minStack.push(2147483647);
        int top = minStack.top();// return 0
        minStack.pop();

        int min1 = minStack.getMin();// return -3
        minStack.pop();

        min1 = minStack.getMin();// return -3
        minStack.pop();
        minStack.push(2147483647);

        top = minStack.top();// return 0
        min1 = minStack.getMin();// return -3

        minStack.push(-2147483648);
        top = minStack.top();// return 0
        min1 = minStack.getMin();// return -3
        minStack.pop();
        min1 = minStack.getMin();// return -3
    }


    public MinStackNoExtraSpace() {
        stack = new Stack<>();
    }

    public void push(int val) {

        if (stack.isEmpty()) {
            stack.push(val);
            minElement = val;
        } else {
            if (minElement >= val) {
                stack.push(val);
            } else {
                long tempVal = (2 * val) - minElement;
                stack.push((int) tempVal);
                minElement = val;
            }
        }
    }

    public void pop() {
        if (stack.peek() < minElement) {
            minElement = (2 * minElement) - stack.peek();
            stack.pop();
        } else
            stack.pop();
    }

    public int top() {
        if (stack.peek() >= minElement) {
            return stack.peek();
        } else {
            return minElement;
        }
    }

    public int getMin() {
        return minElement;
    }

}
