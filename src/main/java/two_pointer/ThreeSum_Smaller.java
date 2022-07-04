package two_pointer;

import java.util.Arrays;

public class ThreeSum_Smaller {
    public static void main(String[] args) {
        //int[] arr = new int[]{-2, 0, 1, 3};
        int[] arr = new int[]{3, 1, 0, -2};
        int target = 4;
        int output = threeSumSmaller(arr, target);
        System.out.println("output " + output);
    }

    public static int threeSumSmaller(int[] nums, int target) {

        int n = nums.length;

        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int L = i + 1, H = n - 1;

            while (L < H) {
                int sum = nums[i] + nums[L] + nums[H];
                if (sum < target) {
                    count += H - L;
                    L++;
                }  else {
                    H--;
                }
            }
        }
        return count;
    }

}