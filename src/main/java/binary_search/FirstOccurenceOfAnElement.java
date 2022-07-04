package binary_search;

public class FirstOccurenceOfAnElement {
    public static void main(String[] args) {
        //int[] arr = new int[]{2, 4, 10, 10, 10, 18, 29};
        int[] arr = new int[]{5, 7, 7, 8, 8, 10};
        int element = 8;
        int index = findFirstIndex(arr, element);
        System.out.println("index " + index);


        index = findFirstIndexApproach2(arr, element);
        System.out.println("index " + index);

    }

    //Failing for scenario -
    //int[] arr = new int[]{5, 7, 7, 8, 8, 10};
    //int element = 6;
    //Can we improve this?
    private static int findFirstIndex(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) { //notice start < end - and not start <= end
            int mid = start + (end - start) / 2;
            int midElement = arr[mid];
            if (element > midElement) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return end;
    }

    public static int findFirstIndexApproach2(int[] arr, int element) {
        int start = 0;
        int end = arr.length - 1;

        int result = -1;
        while (start <= end) { //notice start < end - and not start <= end
            int mid = start + (end - start) / 2;
            int midElement = arr[mid];

            if (midElement == element) {
                result = mid;
            }

            if (element > midElement) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }
}
