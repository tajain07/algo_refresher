package binary_search;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 */
public class PeakElement {
    public static void main(String[] args) {
        int[] arr = new int[]{15, 10, 20, 15};

        int peakElementIndex = peakElement(arr);
        System.out.println("peakElementIndex " + peakElementIndex);
    }


    public static int peakElement(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int size = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid > 0 && mid < arr.length - 1) {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                    return mid;
                else if (arr[mid - 1] > arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (mid == 0)
                if (arr[0] > arr[1])
                    return 0;
                else
                    return 1;
            else if (mid == size - 1)
                if (arr[size - 1] > arr[size - 2])
                    return size - 1;
                else
                    return size - 2;

        }
        return -1;
    }
}