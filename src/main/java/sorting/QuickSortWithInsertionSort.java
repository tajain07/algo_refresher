package sorting;

public class QuickSortWithInsertionSort {
    public static void main(String[] args) {
        int[] arr = {24, 97, 40, 67, 88, 85, 15, 66, 53, 44, 26,
                48, 16, 52, 45, 23, 90, 18, 49, 80, 23};

        hybridQuickSort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.print(i + "  ");
    }

    public static void hybridQuickSort(int arr[], int low, int high) {
        while (low < high) {
            // Check if array size on which we will be working is less than 10
            if (high - low < 10) {
                insertionSort(arr, low, high);
                break;
            } else {
                int pivot = partition(arr, low, high);

                // We will do recursion on small size
                // subarray So we can check pivot - low  and
                // pivot - high

                if (pivot - low < pivot - high) {
                    hybridQuickSort(arr, low, pivot - 1);
                    low = pivot + 1;
                } else {
                    hybridQuickSort(arr, pivot + 1, high);
                    high = pivot - 1;
                }
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        int j = low;

        while (i <= high) {
            if (arr[i] > pivot)
                i++;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            for (int j = i - 1; j >= low; j--) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                } else
                    break;
            }
        }
    }
}
