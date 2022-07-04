package binary_search;


/**
 * Given a sorted array, find the element in the array which has minimum
 * difference with the given number. .
 */
public class MinimumDifferenceElementInASortedArray {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 8, 10, 14, 15};
        int element = 12;
        int minElement = minDifferenceElement(arr, element);
        System.out.println("minElement " + minElement);
    }

    public static int minDifferenceElement(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element)
                return element;
            else if (arr[mid] > element)
                end = mid - 1;
            else
                start = mid + 1;

        }
        int diffStart = Math.abs(arr[start] - element);
        int diffEnd = Math.abs(arr[end] - element);
        return diffStart < diffEnd ? arr[start] : arr[end];
    }
}