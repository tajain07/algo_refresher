package binary_search;

public class IndexOfFirst1InBinarySortedInfiniteArray {

    public static void main(String[] args) {
        int arr[] = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        int pos = findPos(arr, 1);
        System.out.println("pos " + pos);

    }

    public static int findPos(int[] arr, int element) {
        int start = 0;
        int end = 1;
        int answer = -1;
        while (element > arr[end]) {
            start = end;
            end = end * 2 < arr.length ? end * 2 : arr.length - 1;
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == element) {
                answer = mid;
                end = mid - 1;
            } else if (arr[mid] < element)
                start = mid + 1;
            else
                end = mid - 1;
        }

        return answer;
    }
}