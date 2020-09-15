package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallestToRight {
    public static void main(String[] args) {
        int[] a = { 4, 5, 2, 10, 8 };
        NearestSmallestToRight smallestToRight = new NearestSmallestToRight();
        int[] answer = smallestToRight.nearestSmallestToRight(a);
        System.out.println(Arrays.toString(answer));
    }

    private int[] nearestSmallestToRight(int[] nums) {
        Stack <Integer> stack = new Stack <>();
        int[] answer = new int[nums.length];
        int index = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {

            int num = nums[i];

            while (stack.size() > 0 && stack.peek() > num) {
                stack.pop();
            }

            if (stack.size() == 0)
                answer[index] = -1;
            else
                answer[index] = stack.peek();

            index--;
            stack.push(num);
        }
        return answer;
    }

}
