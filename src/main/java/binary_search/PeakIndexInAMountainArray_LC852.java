package binary_search;

public class PeakIndexInAMountainArray_LC852 {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 1};
        int answer = peakIndexInMountainArray(arr);
        System.out.printf("answer " + answer);
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            //you are in dec part of the array
            //this may be the ans, but look at left
            //this is why end != mid-1
            if (arr[mid] > arr[mid + 1])
                end = mid;
            else if (arr[mid] < arr[mid + 1])
                start = mid + 1;

        }
        return start;
    }
}
