package recursion.IBH;

import java.util.Arrays;
import java.util.Stack;

public class SortAStackRecursiveWithRecursiveInsertion {
    public static void main(String[] args) {
        Integer a[] = { -1, 5, 1, 0, 2 };
        //Integer a[] = { 0, 1, 3, 5 };
        Stack <Integer> inputStack = new Stack <>();
        inputStack.addAll(Arrays.asList(a));


        sortStack(inputStack);

        //insert(inputStack, 0);
        System.out.println(inputStack);
    }

    private static void sortStack(Stack <Integer> inputStack) {

        if (inputStack.size() == 1) {
            return;
        }

        int value = inputStack.pop();
        sortStack(inputStack);

        insertRecursive(inputStack, value);
    }

    private static void insertRecursive(Stack <Integer> inputStack, int value) {

        if (inputStack.size() == 0 || inputStack.peek() <= value) {
            inputStack.push(value);
            return;
        }

        final Integer popedElement = inputStack.pop();
        insertRecursive(inputStack, value);

        inputStack.push(popedElement);

    }
}
