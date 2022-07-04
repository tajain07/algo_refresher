package two_pointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4};
        int target = 6;

        int[] pair = twoSum(arr, target);
        System.out.println("Pair " + Arrays.toString(pair));
    }

    private static int[] twoSum(int[] arr, int target) {


        //define points
        int low = 0, n = arr.length, high = n - 1;

        while (low < high) {
            int sum = arr[low] + arr[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum > target) {
                high--;
            } else {
                low++;
            }


        }
        return new int[]{-1, -1};

    }
}