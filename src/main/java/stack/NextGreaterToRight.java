package stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 * <p>
 * https://www.geeksforgeeks.org/next-greater-element/
 */
public class NextGreaterToRight {
    public static void main(String[] args) {
        //int[] a = {13, 7, 6, 12};
        int[] a = {4, 5, 2, 25};
        NextGreaterToRight nextGreaterToRight = new NextGreaterToRight();

        int[] answerBruteForce = nextGreaterToRight.nextGreatestBruteForce(a);
        System.out.println(Arrays.toString(answerBruteForce));

        int[] answer = nextGreaterToRight.nextLargestElement(a);
        System.out.println(Arrays.toString(answer));

        int[] answerNew = nextGreaterToRight.nextGreaterElementToRight(a);
        System.out.println(Arrays.toString(answerNew));

    }


    /**
     * Brute Force
     * Runtime complexity - O(N^2)
     * @param input
     * @return
     */
    public int[] nextGreatestBruteForce(int[] input) {

        int len = input.length;
        int[] output = new int[len];

        for (int i = 0; i < len; i++) {
            int currentElement = input[i];
            int greaterElement = -1;
            for (int j = i + 1; j < len; j++) {
                if (input[j] > currentElement) {
                    greaterElement = input[j];
                    break;
                }
            }
            output[i] = greaterElement;
        }

        return output;
    }


    /**
     * approach 1
     * Runtime complexity - O(N)
     * @param nums
     * @return
     */
    public int[] nextGreaterElementToRight(int[] nums) {
        int[] answer = new int[nums.length];
        int index = nums.length - 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            if (stack.isEmpty()) {
                answer[index] = -1;
            } else if (stack.peek() > num) {
                answer[index] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() <= num) {
                while (stack.size() > 0 && stack.peek() <= num) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    answer[index] = -1;
                } else {
                    answer[index] = stack.peek();
                }
            }
            index--;
            stack.push(num);
        }

        return answer;
    }

    /**
     * approach 2
     * Runtime complexity - O(N)
     * @param nums
     * @return
     */
    public int[] nextLargestElement(int[] nums) {
        int[] answer = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            while (stack.size() > 0 && stack.peek() < num) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(num);
        }
        return answer;
    }
}

