package stack;


import java.util.Stack;

/**
 * https://youtu.be/J2X70jj_I1o
 * https://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 */
public class MaximumAreaOfHistogram {

    /*
    public static void main(String[] args) {
        int[] a = { 6, 2, 5, 4, 5, 1, 6 };
        MaximumAreaOfHistogram maximumAreaOfHistogram = new MaximumAreaOfHistogram();
        int area = maximumAreaOfHistogram.MAH(a);
        System.out.println("area " + area);
    }

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

