package binary_search;

public class SearchInsertPosition_LC35 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 6};

        System.out.println("index " + searchInsert(nums, 5));
        System.out.println("index " + searchInsert(nums, 2));
        System.out.println("index " + searchInsert(nums, 7));
        System.out.println("index " + searchInsert(nums, 0));

    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static int searchInsertOrig(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else return mid;
        }

        return left;
    }
}


