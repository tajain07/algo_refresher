package stack;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://youtu.be/p9T-fE1g1pU
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class StockSpan {
    public static void main(String[] args) {
        int a[] = { 100, 80, 60, 70, 60, 75, 85 };
        StockSpan stockSpan = new StockSpan();
        int[] span = stockSpan.stockSpanUsingStack(a);
        System.out.println(Arrays.toString(span));
    }

    private int[] stockSpanUsingStack(int[] a) {

        Stack <Pair <Integer, Integer>> stack = new Stack <>();
        int[] answer = new int[a.length];
        int index = 0;

        for (int i = 0; i < a.length; i++) {

            int num = a[i];

            while (stack.size() > 0 && stack.peek().getKey() < num) {
                stack.pop();
            }

            if (stack.size() == 0) {
                answer[index] = 1;
            } else {
                answer[index] = i - stack.peek().getValue();
            }

            index++;
            stack.push(new Pair <>(num, i));
        }

        return answer;
    }
}
