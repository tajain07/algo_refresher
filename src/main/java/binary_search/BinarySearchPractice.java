package binary_search;

public class BinarySearchPractice {
    public static void main(String[] args) {
        int[] arr = new int[]{24, 25, 26, 0, 1, 2, 5, 8, 19, 20, 23};
        //int[] arr = new int[]{0, 1, 2, 4, 5, 6, 7, 8, 19};
        int index = indexOfMinimumIndex(arr);
        System.out.println("index " + index);

        int element = 23;
        int foundIndex1 = binary_search(arr, 0, index - 1, element);
        int foundIndex2 = binary_search(arr, index, arr.length - 1, element);

        if (foundIndex1 != -1)
            System.out.println("foundIndex1 " + foundIndex1);
        else
            System.out.println("foundIndex2 " + foundIndex2);

    }


    public static int binary_search(int[] arr, int start, int end, int element) {
        int startIndex = start;
        int endIndex = end;

        while (startIndex <= endIndex) {
            int mid = startIndex + (endIndex - startIndex) / 2;
            if (arr[mid] == element)
                return mid;
            else if (arr[mid] > element)
                endIndex = mid - 1;
            else
                startIndex = mid + 1;

        }

        return -1;
    }

    public static int indexOfMinimumIndex(int[] arr) {
        int N = arr.length;
        if (arr[0] < arr[N - 1])
            return 0;

        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int prev = (mid + N - 1) % N;
            int next = (mid + 1) % N;

            if (arr[prev] > arr[mid] && arr[next] > arr[mid])
                return mid;

            if (arr[start] >= arr[mid])
                end = mid - 1;
            else if (arr[mid] >= arr[end])
                start = mid + 1;
        }
        return -1;
    }
}