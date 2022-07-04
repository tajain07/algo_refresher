package recursion;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6};
        printArray(arr);
        reverseArray(arr, 0, 5);
        System.out.print("Reversed array is \n");
        printArray(arr);
    }

    private static void reverseArray(int[] arr, int start, int end) {

        if (start > end)
            return;


        int temp = arr[end];
        arr[end] = arr[start];
        arr[start] = temp;
        reverseArray(arr, start + 1, end - 1);
    }

    private static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
