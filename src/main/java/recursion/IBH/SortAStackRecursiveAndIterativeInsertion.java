package recursion.IBH;

import java.util.Arrays;
import java.util.Stack;

public class SortAStackRecursiveAndIterativeInsertion {
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

        insertIterative(inputStack, value);
    }


    private static void insertIterative(Stack <Integer> inputStack, int value) {

        final Object[] objects = inputStack.toArray();

        boolean elementInserted = false;
        for (int i = 0; i < inputStack.size(); i++) {
            int element = (int) objects[i];
            if (element > value) {
                inputStack.add(i, value);
                elementInserted = true;
                break;
            }
        }

        //if all elements
        if (!elementInserted) {
            inputStack.add(inputStack.size(), value);
        }
    }
}
