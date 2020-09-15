package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.youtube.com/watch?v=NXOOYYwpbg4&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=2
 *
 * https://www.geeksforgeeks.org/next-greater-element/
 */
public class NextGreaterToRight {
    public static void main(String[] args) {
        //int[] a = { 13, 7, 6, 12};
        int[] a = { 4, 5, 2, 25};
        NextGreaterToRight nextGreaterToRight = new NextGreaterToRight();
        int[] answer = nextGreaterToRight.nextLargestElement(a);
        System.out.println(Arrays.toString(answer));

        int[] answerNew = nextGreaterToRight.nextGreaterElementToRight(a);
        System.out.println(Arrays.toString(answerNew));
    }

    /**
     * approach 1
     * @param nums
     * @return
     */
    private int[] nextGreaterElementToRight(int[] nums){
        int[] answer = new int[nums.length];
        int index = nums.length -1;
        Stack <Integer> stack = new Stack <>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];

            if(stack.size() == 0){
                answer[index]  = -1;
            }

            else if(stack.peek() > num){
                answer[index]  = stack.peek();
            }

            else if(stack.size() > 0 && stack.peek() <= num){
                while (stack.size() > 0  && stack.peek() <= num){
                    stack.pop();
                }

                if(stack.size() == 0){
                    answer[index]  = -1;
                }
                else{
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
     *
     * @param nums
     * @return
     */
    private int[] nextLargestElement(int[] nums) {
        int[] answer = new int[nums.length];
        int index = nums.length - 1;

        Stack <Integer> stack = new Stack <>();

        for (int i = nums.length - 1; i >= 0; i--) {

            int num = nums[i];

            while (stack.size() > 0 && stack.peek() < num) {
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

