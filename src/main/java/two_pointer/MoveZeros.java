package two_pointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/move-zeroes/
 */
public class MoveZeros {
    public static void main(String[] args) {
        //int[] arr = new int[]{12, 1, 0, 3, 0};
        //int[] arr = new int[]{0, 1, 12, 3, 0};
        int[] arr = new int[]{0, 1, 0, 12, 3, 0};
        //int[] arr = new int[]{12, 1, 0, 3, 2};
        final int[] answer = movZeros(arr);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] movZeros(int[] nums) {
        //base case
        int n = nums.length;
        if (n < 2) return nums;

        //define pointers
        int L = 0, R = 1;

        //move zeros to back
        while (R < n) {
            if (nums[L] != 0) {
                L++;
                R++;
            } else if (nums[R] == 0) {
                R++;
            } else {
                int temp = nums[R];
                nums[R] = nums[L];
                nums[L] = temp;
            }
        }

        return nums;
    }

}
