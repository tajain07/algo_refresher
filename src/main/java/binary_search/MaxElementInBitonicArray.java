package binary_search;

/**
 * https://leetcode.com/problems/find-peak-element/
 * <p>
 * https://www.includehelp.com/icp/maximum-value-in-a-bitonic-array.aspx
 */
public class MaxElementInBitonicArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 12, 4, 2};
        int maxElementIndex = maxElementInBitonicArray(arr);
        System.out.println("maxElementIndex " + arr[maxElementIndex]);
    }

    public static int maxElementInBitonicArray(int[] arr) {
        int size = arr.length;
        int start = 0;
        int end = size - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < size - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                return arr[0] > arr[1] ? 0 : 1;
            } else if (mid == size - 1) {
                return arr[size - 1] > arr[size - 2] ? size - 1 : size - 2;
            }
        }

        return -1;
    }

}