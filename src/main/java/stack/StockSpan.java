package stack;


import java.util.Arrays;
import java.util.Stack;

/**
 * https://youtu.be/p9T-fE1g1pU
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class StockSpan {

    public static void main(String[] args) {
        int a[] = {31, 27, 14, 21, 30, 22};
        StockSpan stockSpan = new StockSpan();
        int[] span = stockSpan.stockSpan(a);
        System.out.println(Arrays.toString(span));
    }

    public static int[] stockSpan(int[] input) {

        int[] output = new int[input.length];
        Stack<int[]> stack = new Stack<>();

        for (int index = 0; index < input.length; index++) {

            while (!stack.isEmpty() && input[index] >= stack.peek()[0]) {
                stack.pop();
            }

            output[index] = stack.isEmpty() ? 1 : index - stack.peek()[1];
            stack.push(new int[]{input[index], index});

        }
        return output;

    }
}
