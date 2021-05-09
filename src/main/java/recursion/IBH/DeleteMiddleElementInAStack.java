package recursion.IBH;

import java.util.Stack;

public class DeleteMiddleElementInAStack {

    //Middle element = (size/2)+1;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        int k = (stack.size() / 2) + 1;
        deleteElementUsingK(stack, k);
        System.out.println(stack);
    }


    private static void deleteElementUsingK(Stack<Integer> stack, int k) {

        if (k == 1) {
            stack.pop();
            return;
        }

        int value = stack.pop();
        deleteElementUsingK(stack, k - 1);

        stack.push(value);
    }

    private static void deleteElementUsingStackSize(Stack<Integer> stack, int k) {

        if (k > stack.size())
            return;

        if (k == stack.size()) {
            stack.pop();
            return;
        }
        int value = stack.pop();
        deleteElementUsingStackSize(stack, k);

        stack.push(value);
    }

}
