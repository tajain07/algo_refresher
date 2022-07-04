package two_pointer;

import java.util.Arrays;

/**
 * https://www.interviewbit.com/problems/sort-by-color/
 */
public class SortByColor {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};

        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {
        int n = nums.length;
        int L = 0, R = n-1, curr = 0;

        while (curr <= R) {
            if (nums[curr] == 2) {
                swap(nums, curr, R);
                R--;
            } else if (nums[curr] == 1) {
                curr++;
            } else {
                swap(nums, curr, L);
                L++;
                curr++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
