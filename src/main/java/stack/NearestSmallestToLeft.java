package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://youtu.be/85LWui3FlVk
 */
public class NearestSmallestToLeft {
    public static void main(String[] args) {
        //int[] a = { 1, 3, 2, 4 };
        int[] a = {4, 5, 2, 10, 8};
        NearestSmallestToLeft nearestSmallerToLeft = new NearestSmallestToLeft();
        int[] answer = nearestSmallerToLeft.nearestSmallestToLeft(a);
        System.out.println(Arrays.toString(answer));


        int[] answerUsingBruteForce = nearestSmallerToLeft.nearestSmallestToLeftBruteForce(a);
        System.out.println(Arrays.toString(answerUsingBruteForce));

    }

    public int[] nearestSmallestToLeftBruteForce(int[] nums) {
        int[] output = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int element = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    element = nums[j];
                    break;
                }
            }

            output[i] = element;
        }

        return output;
    }

    /**
     * @param nums
     * @return
     */
    public static int[] nearestSmallestToLeft(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            // Stack is not empty && stack top element is greater than num
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return answer;
    }
}
