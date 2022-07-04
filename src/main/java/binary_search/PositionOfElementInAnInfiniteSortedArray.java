package binary_search;

/**
 * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 *
 */
public class PositionOfElementInAnInfiniteSortedArray {

    public static void main(String[] args) {

        int arr[] = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int ans = findPos(arr, 170);
        System.out.println("ans " + ans);
    }

    public static int findPos(int[] arr, int element) {
        int start = 0;
        int end = 1;

        while (element > arr[end]) {
            start = end;
            end = end * 2 < arr.length ? end * 2 : arr.length - 1;
        }


        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return mid;
            else if (arr[mid] > element)
                end = mid - 1;
            else
                start = mid + 1;
        }
        System.out.println("start " + start);
        System.out.println("end " + end);

        return -1;
    }
}