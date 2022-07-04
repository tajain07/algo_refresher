package binary_search;

import java.util.Arrays;

public class SplitArrayLargestSum_LC410 {
    public static void main(String[] args) {

        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(splitArray(new int[]{1, 2, 3, 4, 5}, 2));
    }

    public static int splitArray(int[] nums, int m) {
        int left = Arrays.stream(nums).max().getAsInt();
        int right = Arrays.stream(nums).sum();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (feasible(nums, m, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean feasible(int[] weights, int D, int capacity) {

        int days = 1;
        int total = 0;
        for (int weight : weights) {
            total += weight;
            if (total > capacity) {
                total = weight;
                days += 1;
                if (days > D)
                    return false;
            }
        }

        return true;
    }
}
