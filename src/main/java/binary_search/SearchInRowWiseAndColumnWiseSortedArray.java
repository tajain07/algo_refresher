package binary_search;

import java.util.Arrays;

/**
 * TC - O(m+n)
 * https://www.geeksforgeeks.org/search-in-row-wise-and-column-wise-sorted-matrix/
 */
public class SearchInRowWiseAndColumnWiseSortedArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 45}, {32, 33, 39, 50}};
        final int[] response = searchInRowWiseAndColumnWiseSortedArray(arr, 23);
        System.out.println(Arrays.toString(response));;
    }

    private static int[] searchInRowWiseAndColumnWiseSortedArray(int[][] arr, int key) {
        int[] response = new int[2];
        Arrays.fill(response, -1);


        final int n = arr.length;
        final int m = arr[0].length;
        int i = 0, j = m - 1;
        while (i >= 0 && i < n && j >= 0 && j < m) {
            if (arr[i][j] == key) {
                response[0] = i;
                response[1] = j;
                return response;
            } else if (arr[i][j] > key) {
                j--;
            } else {
                i++;
            }
        }

        return response;
    }

}
