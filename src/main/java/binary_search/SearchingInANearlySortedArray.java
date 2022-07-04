package binary_search;

/**
 * https://www.geeksforgeeks.org/search-almost-sorted-array/
 *
 * https://youtu.be/W3-KgsCVH1U
 */
public class SearchingInANearlySortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 3, 40, 20, 50, 80, 70};
        int key = 3;
        int index = searchInAlmostSortedArray(arr, key);
        System.out.println("index " + index);
    }

    private static int searchInAlmostSortedArray(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return mid;
            else if (mid - 1 >= start && arr[mid - 1] == element)
                return mid - 1;
            else if (mid + 1 <= end && arr[mid + 1] == element)
                return mid + 1;
            else if (mid - 1 >= start && arr[mid - 1] > element)
                end = mid - 2;
            else if (mid - 1 >= start && arr[mid - 2] < element)
                start = mid + 2;

        }

        return -1;
    }
}
