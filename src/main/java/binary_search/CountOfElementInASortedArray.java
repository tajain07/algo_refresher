package binary_search;

/**
 * COUNT NUMBER OF OCURRENCES(or frequency) IN A SORTED ARRAY:
 * <p>
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn)
 * Examples:
 * <p>
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
 * Output: 4 // x (or 2) occurs 4 times in arr[]
 * <p>
 * Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 3
 * Output: 1
 */
public class CountOfElementInASortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 10, 10, 10, 18, 20};
        int element = 180;
        int count = countOfElement(arr, element, 0, arr.length - 1);
        System.out.println("count " + count);

        count = countOfElementApproach2(arr, element);
        System.out.println("count of elment using first and last occuerrence methods " + count);
    }

    private static int countOfElementApproach2(int[] arr, int i) {
        int firstOccurrence = FirstOccurenceOfAnElement.findFirstIndexApproach2(arr, i);
        int lastOccurrence = LastOccurrenceOfAnElement.findLastOccurrence(arr, i);
        if (firstOccurrence == -1)
            return 0;
        return lastOccurrence - firstOccurrence + 1;
    }

    private static int countOfElement(int[] arr, int element, int startIndex, int endIndex) {
        int start = startIndex;
        int end = endIndex;
        int count = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = arr[mid];
            if (midElement == element) {
                count++;
                count += countOfElement(arr, element, startIndex, mid - 1);
                count += countOfElement(arr, element, mid + 1, endIndex);
                return count;
            } else if (element < midElement) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return count;
    }
}
