package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {
    public static void main(String[] args) {
        //int[] a = { 1, 3, 2, 4 };
        int[] a = { 4, 5, 2, 10, 8 };
        NearestSmallerToLeft nearestSmallerToLeft = new NearestSmallerToLeft();
        int[] answer = nearestSmallerToLeft.nearestSmallerToLeft(a);
        System.out.println(Arrays.toString(answer));

    }

    private int[] nearestSmallerToLeft(int[] nums) {
        Stack <Integer> stack = new Stack <>();
        int[] answer = new int[nums.length];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (stack.size() > 0 && stack.peek() > num) {
                stack.pop();
            }

            if (stack.size() == 0)
                answer[index] = -1;
            else
                answer[index] = stack.peek();

            index++;
            stack.push(num);

        }
        return answer;
    }
}
