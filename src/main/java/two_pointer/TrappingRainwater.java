package two_pointer;

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
 * We can trap "3*2 units" of water between 3 an 2,
 * "1 unit" on top of bar 2 and "3 units" between 2
 * and 4
 *
 * <p>
 * <p>
 * https://www.geeksforgeeks.org/trapping-rain-water/
 * https://leetcode.com/problems/trapping-rain-water/solution/
 * <p>
 * https://youtu.be/FbGG2qpNp4U
 */
public class TrappingRainwater {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 2};
        int totalWater = totalRainWaterTrapping(arr);
        totalWater = trap(arr);
        System.out.println("totalWater " + totalWater);
    }

    public static int trap(int[] height) {
        int max = 0, n = height.length;
        for (int i = 0; i < n; i++) {
            if (height[max] < height[i])
                max = i;
        }
        int sum = 0;
        int LeftMax = 0;
        for (int i = 0; i < max; i++) {
            if (height[LeftMax] < height[i])
                LeftMax = i;
            sum += Math.min(height[LeftMax], height[max]) - height[i];
        }
        int RightMax = n - 1;
        for (int i = n - 1; i > max; i--) {
            if (height[RightMax] < height[i])
                RightMax = i;
            sum += Math.min(height[max], height[RightMax]) - height[i];
        }
        return sum;
    }

    public static int totalRainWaterTrapping(int[] arr) {
        int maxLeft = arr[0];
        int maxRight = arr[arr.length - 1];
        int trappedWater = 0;

        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            if (maxLeft < maxRight) {
                if (arr[left] > maxLeft) {
                    maxLeft = arr[left];

                } else {
                    trappedWater += maxLeft - arr[left];
                }
                left++;
            } else {

                if (arr[right] > maxRight) {
                    maxRight = arr[right];

                } else {
                    trappedWater += maxRight - arr[right];
                }
                right--;
            }
        }
        return trappedWater;
    }


}
