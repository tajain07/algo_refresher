package binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Index of 0 is " + findElement(arr, 0));
        System.out.println("Index of 2 is " + findElement(arr, 2));
        System.out.println("Index of 3 is " + findElement(arr, 3));
        System.out.println("Index of 4 is " + findElement(arr, 4));
        System.out.println("Index of 5 is " + findElement(arr, 5));
        System.out.println("Index of 6 is " + findElement(arr, 6));
        System.out.println("Index of 7 is " + findElement(arr, 7));
        System.out.println("Index of 8 is " + findElement(arr, 8));
        System.out.println("Index of 9 is " + findElement(arr, 9));
        System.out.println("Index of -1 is " + findElement(arr, -1));
        System.out.println("Index of 100 is " + findElement(arr, 100));

    }

    public static int findElement(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (element == arr[mid])
                return mid;
            else if (element < arr[mid]) {
                end = mid - 1;
            } else
                start = mid + 1;
        }

        return -1;
    }
}
