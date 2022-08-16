package recursion.IBH;

import java.util.List;
import java.util.Stack;

public class DeleteMiddleElementInAStack {

    //Middle element = (size/2)+1;

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.addAll(List.of(new Integer[]{1, 2, 3, 4, 5}));


        int k = (stack.size() / 2) + 1;
        deleteElementUsingK(stack, k);
        System.out.println(stack);

        //Approach 1 - using k
        stack = new Stack<>();
        stack.addAll(List.of(new Integer[]{1, 2, 3, 4, 5}));

        //Approach 2 - using stack size
        deleteElementUsingStackSize(stack, k - 1);
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
