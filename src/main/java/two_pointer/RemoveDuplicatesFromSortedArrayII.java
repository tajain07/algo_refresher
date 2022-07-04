package two_pointer;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
 */
public class RemoveDuplicatesFromSortedArrayII {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int count = removeDuplicate2(arr);
        System.out.println("arr " + Arrays.toString(arr) + " count " + count);
    }

    private static int removeDuplicate2(int[] nums) {
        int n = nums.length;
        if (n < 3)
            return n;

        int L = 0, H = 1, count = 0;

        while (H < n) {
            if (nums[L] == nums[H] && count < 1) {
                count++;
                L++;
                nums[L] = nums[H];
            }

            else if (nums[L] != nums[H]) {
                L++;
                nums[L] = nums[H];
                count = 0;
            }

            H++;
        }

        return L+1;
    }
}
