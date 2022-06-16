package stack;


import java.util.Arrays;
import java.util.Stack;

/**
 * https://youtu.be/J2X70jj_I1o
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class MaximumAreaOfHistogram {


    public static void main(String[] args) {
        int[] a = {6, 2, 5, 4, 5, 1, 6};
        int area = maxAreaOfHistogram(a);
        System.out.println("area " + area);
    }


    private static int[] nearestSmallestToLeft(int[] input) {
        int[] output = new int[input.length];
        Stack<Integer[]> stack = new Stack<Integer[]>();
        for (int i = 0; i < input.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] >= input[i]) {
                stack.pop();
            }
            output[i] = stack.isEmpty() ? -1 : stack.peek()[1];
            stack.push(new Integer[]{input[i], i});
        }
        return output;
    }

    private static int[] nearestSmallestToRight(int[] input) {
        int[] output = new int[input.length];
        Stack<Integer[]> stack = new Stack<Integer[]>();
        for (int i = input.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] >= input[i]) {
                stack.pop();
            }
            output[i] = stack.isEmpty() ? input.length : stack.peek()[1];
            stack.push(new Integer[]{input[i], i});
        }


        return output;
    }

    public static int maxAreaOfHistogram(int[] lengths) {

        int[] leftSmallers = nearestSmallestToLeft(lengths);
        //System.out.println(Arrays.toString(leftSmallers));
        int[] rightSmallers = nearestSmallestToRight(lengths);
        //System.out.println(Arrays.toString(rightSmallers));

        int maxArea = -1;
        for (int i = 0; i < lengths.length; i++) {
            int length = rightSmallers[i] - leftSmallers[i] - 1;
            int height = lengths[i];
            int area = length * height;
            if (maxArea < area)
                maxArea = area;
        }

        return maxArea;
    }
     /*
    public int MAH(int[] a) {
        Pair[] nearestSmallerToLeft = nearestSmallerToLeft(a);
        Pair[] nearestSmallerToRight = nearestSmallerToRight(a);

        int maxArea = 0;
        for (int i = 0; i < a.length; i++) {
            final Pair left = nearestSmallerToLeft[i];
            final Pair right = nearestSmallerToRight[i];

            final int leftIndex = (int) left.getValue();
            final int rightIndex = (int) right.getValue();

            int area = (rightIndex - leftIndex - 1) * a[i];

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private Pair[] nearestSmallerToRight(int[] a) {

        Stack <Pair> stack = new Stack <>();
        Pair[] answer = new Pair[a.length];
        int index = a.length - 1;

        for (int i = a.length - 1; i >= 0; i--) {
            int num = a[i];

            while (stack.size() > 0 && (int) stack.peek().getKey() >= num) {
                stack.pop();
            }

            if (stack.size() == 0) {
                answer[index] = new Pair(num, a.length);
            } else {
                answer[index] = stack.peek();
            }

            index--;
            stack.push(new Pair(num, i));
        }

        return answer;
    }

    private Pair[] nearestSmallerToLeft(int[] a) {

        Stack <Pair> stack = new Stack <>();
        Pair[] answer = new Pair[a.length];
        int index = 0;

        for (int i = 0; i < a.length; i++) {
            int num = a[i];

            while (stack.size() > 0 && (int) stack.peek().getKey() >= num) {
                stack.pop();
            }

            if (stack.size() == 0) {
                answer[index] = new Pair(num, -1);
            } else {
                answer[index] = stack.peek();
            }

            index++;
            stack.push(new Pair(num, i));

        }

        return answer;
    }

     */

}

