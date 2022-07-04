package sorting;

/**
 * https://www.geeksforgeeks.org/counting-inversions/
 * O(NlogN)
 */
public class InversionCount {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 2, 6, 3};
        int inversionCount = getInversionCount_BruteForce(arr);
        inversionCount = getInversionCount_MergeSort(arr);
        System.out.println(inversionCount);
    }

    private static int getInversionCount_MergeSort(int[] arr) {

        return mergeSortWithInversionCount(arr, 0, arr.length - 1);
    }

    private static int mergeSortWithInversionCount(int[] arr, int l, int r) {
        int tempCount = 0;
        if (r <= l)
            return tempCount;

        int m = (l + r) / 2;
        tempCount += mergeSortWithInversionCount(arr, l, m);
        tempCount += mergeSortWithInversionCount(arr, m + 1, r);
        tempCount += merge(arr, l, m, r);


        return tempCount;
    }

    private static int merge(int[] arr, int l, int m, int r) {
        int count = 0;
        int[] tempArr = new int[r - l + 1];

        int i = l;
        int j = m + 1;
        int z = 0;
        while (i <= m && j <= r) {
            //If we select the jth element (from right part), the no. of elements
            //remaining in the left part forms inversion with jth element
            if (arr[j] < arr[i]) {
                count += m - i + 1;
                tempArr[z++] = arr[j++];
            } else {
                tempArr[z++] = arr[i++];

            }
        }

        while (i <= m) {
            tempArr[z++] = arr[i++];
        }

        while (j <= r) {
            tempArr[z++] = arr[j++];
        }


        z = 0;
        for (int k = l; k <= r; k++) {
            arr[k] = tempArr[z++];
        }


        return count;
    }


    public static int getInversionCount_BruteForce(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i < j && arr[i] > arr[j]) {
                    count++;
                    //System.out.println("i " + i + " j " + j);
                }
            }
        }

        return count;
    }
}
