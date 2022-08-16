package leetcode_contest_302;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-number-of-pairs-in-array/
 */
public class MaxPairInArray {
    public static void main(String[] args) {
        //int[] nums = {0, 0, 1, 1, 2, 2};
        //int[] nums = {1,3,2,1,3,2,2};
        //int[] nums = {1, 1};
        int[] nums = {1, 0, 0};
        int[] pair = numberOfPairs(nums);
        System.out.println(Arrays.toString(pair));
    }

    public static int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> intCount = new HashMap<>();

        for (int num : nums) {
            int currentCount = intCount.getOrDefault(num, 0);
            intCount.put(num, currentCount + 1);
        }

        int removeCount = 0;
        int size = nums.length;
        for (Map.Entry<Integer, Integer> entry : intCount.entrySet()) {
            int num_pairs = entry.getValue() / 2;
            if (num_pairs > 0) {
                removeCount += num_pairs;
                size -= num_pairs * 2;
            }
        }

        return new int[]{removeCount, size};
    }


}
