package stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * Input: arr[]   = {2, 0, 2}
 * Output: 2
 * Structure is like below
 * | |
 * |_|
 * We can trap 2 units of water in the middle gap.
 * <p>
 * Input: arr[]   = {3, 0, 0, 2, 0, 4}
 * Output: 10
 * Structure is like below
 * |
 * |    |
 * |  | |
 * |__|_|
 * We can trap "3*2 units" of water between 3 an 2,
 * "1 unit" on top of bar 2 and "3 units" between 2
 * and 4.  See below diagram also.
 * <p>
 * <p>
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water/solution/
 * <p>
 * https://youtu.be/FbGG2qpNp4U
 */
public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2};
        int totalWater = totalRainWaterTrapping(arr);
        System.out.println("totalWater " + totalWater);
    }

    private static int totalRainWaterTrapping(int[] arr) {
        int[] leftMax = getLeftMax(arr);
        int[] rightMax = getRightMax(arr);

        int totalWater = 0;
        for (int i = 0; i < arr.length; i++) {
            final int min = Math.min(leftMax[i], rightMax[i]);

            totalWater += (min - arr[i]);
        }

        return totalWater;
    }

    private static int[] getRightMax(int[] arr) {
        int[] output = new int[arr.length];

        output[arr.length - 1] = arr[arr.length - 1];
        int max = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {


            if (arr[i] > max)
                max = arr[i];

            output[i] = max;
        }

        return output;
    }

    private static int[] getLeftMax(int[] arr) {

        int[] output = new int[arr.length];

        output[0] = arr[0];

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {


            if (arr[i] > max)
                max = arr[i];

            output[i] = max;
        }

        return output;

    }
}
