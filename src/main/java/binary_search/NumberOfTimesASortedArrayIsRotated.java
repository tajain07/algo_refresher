package binary_search;

/**
 * Find the Rotation Count in Rotated Sorted array
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
 * <p>
 * Examples:
 * <p>
 * Input : arr[] = {15, 18, 2, 3, 6, 12}
 * Output: 2
 * Explanation : Initial array must be {2, 3,
 * 6, 12, 15, 18}. We get the given array after
 * rotating the initial array twice.
 * <p>
 * Input : arr[] = {7, 9, 11, 12, 5}
 * Output: 4
 * <p>
 * Input: arr[] = {7, 9, 11, 12, 15};
 * Output: 0
 */
public class NumberOfTimesASortedArrayIsRotated {
    public static void main(String[] args) {
        int[] arr = new int[]{19, 22, 22, 23, 24, 1, 2, 5, 8};
        int numberOfRotations = findNumberOfRotationApproach2(arr);
        System.out.println("numberOfRotations " + numberOfRotations);

        numberOfRotations = findNumberOfRotation(arr);
        System.out.println("numberOfRotations " + numberOfRotations);

    }


    private static int findNumberOfRotation(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) {
            return 0;
        }

        int N = arr.length;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = arr[mid];
            int next = (mid + 1) % N;
            int prev = (mid + N - 1) % N;

            //left and right element are greater than mid element - we found min element
            if (arr[prev] > midElement && arr[next] > midElement) {
                return mid;
            }
            //first element is less than mid element - means this part is sorted, move to other half
            else if (arr[0] <= midElement) {
                start = mid + 1;
            }
            //if mid is smaller than last element- means this part is sorted, move to first half.
            else if (midElement <= arr[arr.length - 1]) {
                end = mid - 1;
            }

        }

        return -1;
    }

    // Index of min element
    private static int findNumberOfRotationApproach2(int[] nums) {
        int minElementIndex = 0;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = nums[mid];
            int minElement = nums[minElementIndex];
            if (midElement > minElement) {
                start = mid + 1;
            } else if (midElement < minElement) {
                minElementIndex = mid;
                end = mid - 1;
            }

        }

        return minElementIndex;
    }
}
