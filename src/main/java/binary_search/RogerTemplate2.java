package binary_search;

public class RogerTemplate2 {

    public static int search2(int[] nums, int target) {
        int lo = 0, hi = nums.length ;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        if (nums[lo] != target)
            return -1;

        return lo;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 1, 1, 1, 1};

        for (int i = 0; i < 15; i++) {
            System.out.println("i " + i + " " + search2(nums, i));
        }
    }
}
