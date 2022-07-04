package binary_search;

import java.util.Arrays;

public class FindInMountainArray_LC1095 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,4,2,1};
        int peakIndex = peakIndexInMountainArray(arr);

        int target = 3;
        int answer = findInMountainArray(target, arr);
        System.out.println("answer " + answer);

    }

    public static int findInMountainArray(int target, int[] mountainArr) {
        int peakIndex = peakIndexInMountainArray(mountainArr);
        int firstIndex = binarySearch(mountainArr, target, 0, peakIndex);
        int secondIndex = binarySearch(mountainArr, target, peakIndex + 1, mountainArr.length - 1);

        System.out.println(firstIndex);
        System.out.println(secondIndex);

        int count = 0;
        if (firstIndex != -1)
            count += 1;
        if (secondIndex != -1)
            count += 1;

        return count;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            //you are in dec part of the array
            //this may be the ans, but look at left
            //this is why end != mid-1
            if (arr[mid] > arr[mid + 1])
                end = mid;
            else if (arr[mid] < arr[mid + 1])
                start = mid + 1;

        }
        return start;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid])
                start = mid + 1;
            else
                return mid;
        }
        return -1;
    }
}
