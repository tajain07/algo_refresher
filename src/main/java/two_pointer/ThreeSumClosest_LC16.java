package two_pointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest_LC16 {
    public static void main(String[] args) {
        //int[] arr = new int[]{-1, 2, 1, -4};  //-4, -1, 1, 2
        //int[] arr = new int[]{-1, 2, 1,-2, -4};  //-4, -2, -1, 1, 2
        //int[] arr = new int[]{1, 1, 1, 0};  //0,1,1,1
        int[] arr = new int[]{0, 2, 1, -3};  //-3, 0, 1, 2
        //         ^  ^  ^
        int target = 1;

        int output = get3SumClosest(arr, target);
        System.out.println("output " + output);
    }

    private static int get3SumClosest(int[] arr, int target) {

        Arrays.sort(arr);
        int gap = Integer.MAX_VALUE, ans = 0, n = arr.length;

        for (int i = 0; i < n; i++) {
            int L = i + 1, R = n - 1;
            while (L < R) {
                int curSum = arr[L] + arr[R] + arr[i];
                if (curSum == target)
                    return target;
                else if (curSum < target) {
                    L++;
                } else
                    R--;
                int currGap = Math.abs(curSum - target);
                if (currGap < gap) {
                    gap = currGap;
                    ans = curSum;
                }
            }
        }
        return ans;
    }
}
