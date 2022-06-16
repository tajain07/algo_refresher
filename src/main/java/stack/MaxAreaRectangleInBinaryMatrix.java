package stack;

import java.util.Arrays;

/**
 * https://youtu.be/St0Jf_VmG_g
 * <p>
 * https://leetcode.com/problems/maximal-square/
 * <p>
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

    public static void main(String[] args) {
        int[][] binaryMatrix = {{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
        char[][] binaryMatrixChar = {{'0', '1', '1', '0'}, {'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'1', '1', '0', '0'}};

        int maxArea = maxAreaRectangle(binaryMatrix);
        System.out.println("maxArea : " + maxArea);

        int maxArea2 = maxAreaRectangle(binaryMatrixChar);
        System.out.println("maxArea2 : " + maxArea2);
    }

    /**
     * Approach 1
     *
     * @param binaryMatrix
     * @return
     */
    private static int maxAreaRectangle(int[][] binaryMatrix) {

        int maxArea = -1;
        for (int i = 0; i < binaryMatrix.length; i++) {
            int[] length = getBuildingHeight(binaryMatrix, i);
            int currentMax = MaximumAreaOfHistogram.maxAreaOfHistogram(length);
            if (maxArea < currentMax)
                maxArea = currentMax;
        }

        return maxArea;
    }

    private static int[] getBuildingHeight(int[][] binaryMatrix, int currentLevel) {
        int columnsLength = binaryMatrix[0].length;
        int[] output = new int[columnsLength];


        for (int col = 0; col < columnsLength; col++) {
            int height = 0;
            for (int row = currentLevel; row >= 0; row--) {
                if (row != 0 && binaryMatrix[row][col] == 0)
                    break;
                else if (binaryMatrix[row][col] > 0) {
                    height += binaryMatrix[row][col];
                }
            }

            output[col] = height;
        }

        return output;

    }


    /**
     * Approach 2
     *
     * @param matrix
     * @return
     */
    private static int maxAreaRectangle(char[][] matrix) {
        int[] base = new int[matrix[0].length];

        int maxArea = Integer.MIN_VALUE;

        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                int val = chars[j] - '0';
                if (val == 0)
                    base[j] = 0;
                else
                    base[j] += val;
            }

            //System.out.println(Arrays.toString(base));
            maxArea = Math.max(MaximumAreaOfHistogram.maxAreaOfHistogram(base), maxArea);

        }

        return maxArea;
    }


}
