package recursion.IBH;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack <>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);

        //       insertAtTheEnd(stack, 5);

        System.out.println("Before reverse " + stack);
        reverseStack(stack);
        System.out.println("After reverse " + stack);
    }

    private static void reverseStack(Stack <Integer> stack) {

        if (stack.size() == 1)
            return;

        final Integer pop = stack.pop();
        reverseStack(stack);

        insertAtTheEnd(stack, pop);
    }

    private static void insertAtTheEnd(Stack <Integer> stack, int element) {

        if (stack.size() == 0) {
            stack.push(element);
            return;
        }

        int topElement = stack.pop();
        insertAtTheEnd(stack, element);

        stack.push(topElement);
    }
}
