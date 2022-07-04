package two_pointer;

/**
 *
 */
public class MinDifferenceTriplet {
    public static void main(String[] args) {
        int arr1[] = new int[]{1, 4, 5, 8, 10};
        int arr2[] = new int[]{6, 9, 15};
        int arr3[] = new int[]{2, 3, 6, 6};

        int diff = minDifference(arr1, arr2, arr3);
        System.out.println("diff " + diff);
    }

    public static int minDifference(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        int minDifference = Integer.MAX_VALUE;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            int x = arr1[i];
            int y = arr2[j];
            int z = arr3[k];
            int currentMinimum = Math.min(Math.min(x, y), z);
            int currentMaximum = Math.max(Math.max(x, y), z);
            int currentDiff = Math.abs(currentMaximum - currentMinimum);
            minDifference = Math.min(currentDiff, minDifference);

            if (currentMinimum == x)
                i++;
            else if (currentMinimum == y)
                j++;
            else k++;
        }

        return minDifference;

    }
}
