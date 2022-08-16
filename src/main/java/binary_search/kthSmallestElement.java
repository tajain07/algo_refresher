package binary_search;

public class kthSmallestElement {
    public static void main(String[] args) {
        int[] nums = {20, 3, 3, 3, 7, 11, 15, 1};
        int k = 5;
        final int kthElement = kthSmallest(nums, k);
        System.out.println("kthElement " + kthElement);

    }

    static int kthSmallest(int[] nums, int k) {
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (count(nums, mid) < k)
                low = mid + 1;

            else
                high = mid;
        }
        return low;

    }

    private static int count(int[] nums, int mid) {
        int count = 0;
        for (int num : nums) {
            if (num <= mid)
                count++;
        }

        return count;
    }
}
