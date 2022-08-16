package recursion.IBH;

import java.util.Arrays;

public class SortArrayApproach1_Recursive {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 9, 6, 4, 9, 3};
        arr = sortArray(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] sortArray(int[] arr, int start, int end) {

        if (start == end)
            return arr;

        arr = sortArray(arr, start, end - 1);

        arr = placeElementInSortedArray(arr, start, end - 1, arr[end]);

        return arr;
    }

    public static int[] placeElementInSortedArray(int[] arr, int start, int end, int element) {

        //If empty array or last element less than the element
        if (end < start || arr[end] < element) {
            arr[end + 1] = element;
            return arr;
        }


        int endElement = arr[end];
        arr = placeElementInSortedArray(arr, start, end - 1, element);
        arr[end + 1] = endElement;
        return arr;

    }
}
