package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestToRight {
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 1, 1};
        NearestSmallestToRight smallestToRight = new NearestSmallestToRight();
        /*int[] answer = smallestToRight.nearestSmallestToRight(a);
        System.out.println(Arrays.toString(answer));*/

        int[] answer = smallestToRight.nearestSmallestToRightBruteForce(a);
        System.out.println(Arrays.toString(answer));

    }

    public static int[] nearestSmallestToRightBruteForce(int[] nums) {
        int[] output = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int element = -1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    element = nums[j];
                    break;
                }
            }

            output[i] = element;
        }

        return output;
    }

    public int[] nearestSmallestToRight(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (stack.size() > 0 && stack.peek() >= nums[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return answer;
    }

}
