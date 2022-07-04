package binary_search;

public class OrderAgnosticSearch {
    public static void main(String[] args) {

        System.out.println("Index of 8 is " + orderAgnosticBinarySearch(new int[]{20, 17, 15, 14, 13, 12, 10, 9, 8, 4}, 8));
        System.out.println("Index of 8 is " + orderAgnosticBinarySearch(new int[]{2, 3, 8, 14, 16, 22, 30, 39, 48, 114}, 8));
        System.out.println("Index of 5 is " + orderAgnosticBinarySearch(new int[]{2}, 5));
        System.out.println("Index of 2 is " + orderAgnosticBinarySearch(new int[]{2}, 2));
    }

    private static int orderAgnosticBinarySearch(int[] arr, int element) {
        if (arr[0] > arr[arr.length - 1]) {
            return BinarySearchOnDescendingSortedArray.findElement(arr, element);
        } else {
            return BinarySearch.findElement(arr, element);
        }
    }
}
