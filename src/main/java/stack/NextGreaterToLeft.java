package stack;

import java.util.Arrays;
import java.util.Stack;

/*
https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3

 */
public class NextGreaterToLeft {

    public static void main(String[] args) {
        //int[] a = { 13, 7, 6, 12};
        //int[] a = { 4, 5, 2, 25 };
        int[] a = { 1, 3, 2, 4 };
        NextGreaterToLeft nextGreaterToLeft = new NextGreaterToLeft();
        int[] answer = nextGreaterToLeft.nextLargestElementToLeft(a);
        System.out.println(Arrays.toString(answer));

        //int[] answerNew = nextGreaterToRight.nextGreaterElementToRight(a);
        //System.out.println(Arrays.toString(answerNew));
    }

    private int[] nextLargestElementToLeft(int[] nums) {
        Stack <Integer> stack = new Stack <>();
        int[] answer = new int[nums.length];

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            while (stack.size() > 0 && stack.peek() < num) {
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
