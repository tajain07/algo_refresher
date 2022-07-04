package two_pointer;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        //int[] arr = new int[]{1, 1};
        //int[] arr = new int[]{1};
        int count = removeDuplicate_Approach1(arr);
        System.out.println("arr " + Arrays.toString(arr));

        count = removeDuplicate_Approach2(arr);
        System.out.println("updatedArray count " + count);
        System.out.println("arr " + Arrays.toString(arr));

    }

    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param arr
     * @return
     */
    public static int removeDuplicate_Approach1(int[] arr) {
        int n = arr.length;

        //base case
        if (n == 0) {
            return 0;
        }

        //define pointers
        int L = 1, R = 1;

        //remove dup in place
        while (R < n) {
            if (arr[R] != arr[R - 1]) {
                arr[L] = arr[R];
                L++;
            }
            R++;
        }
        //return size of subArray
        return L;
    }


    /**
     * Time: O(n)
     * Space: O(1)
     *
     * @param arr
     * @return
     */
    public static int removeDuplicate_Approach2(int[] arr) {
        int n = arr.length;

        //base case
        if (n == 0) {
            return 0;
        }

        //define pointers
        int L = 0, R = 1;

        //remove dup in place
        while (R < n) {
            if (arr[L] != arr[R]) {
                L++;
                arr[L] = arr[R];
            }
            R++;
        }
        //return size of subArray
        return L + 1;
    }
}
