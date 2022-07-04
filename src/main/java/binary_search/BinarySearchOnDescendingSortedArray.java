package binary_search;

public class BinarySearchOnDescendingSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4};
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
        System.out.println("Index of 14 is " + findElement(arr, 14));
        System.out.println("Index of 13 is " + findElement(arr, 13));
        System.out.println("Index of 17 is " + findElement(arr, 17));
        System.out.println("Index of 20 is " + findElement(arr, 20));
    }

    public static int findElement(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = arr[mid];
            if (midElement == element)
                return mid;
            else if (midElement > element) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }
        return -1;
    }
}
