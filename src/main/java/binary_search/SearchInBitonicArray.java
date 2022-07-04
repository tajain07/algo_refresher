package binary_search;

/**
 * https://www.geeksforgeeks.org/find-element-bitonic-array/
 */
public class SearchInBitonicArray {
    public static void main(String[] args) {
        //int[] arr = new int[]{-3, 4, 8, 20, 177};
        int[] arr = new int[]{177, 150, 110, 80, 70};
        int key = 771;
        int index = findPos(arr, key);
        System.out.println("index " + index);
    }

    private static int findPos(int[] arr, int key) {
        int indexOfMaxElement = MaxElementInBitonicArray.maxElementInBitonicArray(arr);
        if (indexOfMaxElement > 0) {
            int index1 = binarySearch(arr, 0, indexOfMaxElement, key, true);
            if (index1 != -1)
                return index1;
        } else if (arr[0] == key) {
            return 0;
        }

        if (indexOfMaxElement < arr.length - 1) {
            int index2 = binarySearch(arr, indexOfMaxElement + 1, arr.length - 1, key, false);
            if (index2 != -1)
                return index2;
        } else if (arr[arr.length - 1] == key) {
            return arr.length - 1;
        }

        return -1;
    }

    private static int binarySearch(int[] arr, int start, int end, int element, boolean isAscending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return mid;
            else if (arr[mid] > element) {
                if (isAscending)
                    end = mid - 1;
                else {
                    start = mid + 1;
                }
            } else if (arr[mid] < element)
                if (isAscending)
                    start = mid + 1;
                else
                    end = mid - 1;
        }

        return -1;
    }
}
