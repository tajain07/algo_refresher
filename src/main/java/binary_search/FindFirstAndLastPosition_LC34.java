package binary_search;

import java.util.Arrays;

public class FindFirstAndLastPosition_LC34 {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 10};
        int target = 8;

        int[] answer = startAndEndIndex(nums, target);
        System.out.println(Arrays.toString(answer));
    }


    static int[] startAndEndIndex(int[] nums, int target) {

        int[] answer = new int[]{-1, -1};

        int startIndex = searchIndex(nums, target, true);
        int endIndex = searchIndex(nums, target, false);

        answer[0] = startIndex;
        answer[1] = endIndex;

        return answer;
    }


    static int searchIndex(int[] nums, int target, boolean searchingFirstIndex) {

        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                if (searchingFirstIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}
