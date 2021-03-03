package stack;

import java.util.Arrays;

/**
 * https://youtu.be/St0Jf_VmG_g
 *
 * https://leetcode.com/problems/maximal-square/
 *
 * Given a binary matrix, find the maximum size rectangle binary-sub-matrix with all 1’s.
 * Example:
 * Input :   0 1 1 0
 * 1 1 1 1
 * 1 1 1 1
 * 1 1 0 0
 * Output :  1 1 1 1
 * 1 1 1 1
 */
public class MaxAreaRectangleInBinaryMatrix {
    /*
    public static void main(String[] args) {
        char[][] binaryMatrix = { { '0', '1', '1', '0' }, { '1', '1', '1', '1' }, { '1', '1', '1', '1' }, { '1', '1', '0', '0' } };

        MaxAreaRectangleInBinaryMatrix maxAreaRectangleInBinaryMatrix = new MaxAreaRectangleInBinaryMatrix();
        int maxArea = maxAreaRectangleInBinaryMatrix.maxAreaRectangle(binaryMatrix);
        System.out.println("maxArea : " + maxArea);
    }

    private int maxAreaRectangle(char[][] matrix) {
        MaximumAreaOfHistogram maximumAreaOfHistogram = new MaximumAreaOfHistogram();

        int[] base = new int[matrix[0].length];

        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = matrix[i][j] - '0';
                if (val == 0)
                    base[j] = 0;
                else
                    base[j] += val;
            }

            System.out.println(Arrays.toString(base));
            maxArea = Math.max(maximumAreaOfHistogram.MAH(base), maxArea);

        }

        return maxArea;
    }

     */
}
