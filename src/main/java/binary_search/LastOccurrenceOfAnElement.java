package binary_search;

public class LastOccurrenceOfAnElement {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 10, 10, 10, 10, 29};
        int element = 29;
        int index = findLastOccurrence(arr, element);
        System.out.println("index " + index);


        //index = findFirstIndexApproach2(arr, element);
        //System.out.println("index " + index);
    }

    public static int findLastOccurrence(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midElement = arr[mid];
            if (element < midElement) {
                end = mid - 1;
            } else if (element > midElement) {
                start = mid + 1;
            } else {
                result = mid;
                start = mid + 1;
            }

        }
        return result;
    }
}
