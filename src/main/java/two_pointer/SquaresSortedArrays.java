package two_pointer;

import java.util.Arrays;

/**
 * https://youtu.be/Dp288aCwk8Y
 */
public class SquaresSortedArrays {
    public static void main(String[] args) {
        int[] arr = new int[]{-1};
        //int[] arr = new int[]{-5, -3, -2, -1};
        //int[] arr = new int[]{-4, -1, 0, 3, 10};

        //int[] arr = new int[]{-7, -3, 2, 3, 11};

        //int[] newArr = squaresSortedArrays_BruteForce(arr);
        //int[] newArr = squaresSortedArrays_TwoPointer(arr);

        int[] newArr = squaresSortedArrays_SmallValuesToLargeValues(arr);
        System.out.println("newArr " + Arrays.toString(newArr));
    }

    public static int[] squaresSortedArrays_SmallValuesToLargeValues(int[] nums) {
        int left = 0, n = nums.length, right = n - 1, index = n - 1;
        int[] res = new int[n];

        while (0 <= index) {
            int leftNum = nums[left] * nums[left];
            int rightNum = nums[right] * nums[right];
            if (leftNum < rightNum) {
                res[index--] = rightNum;
                right--;
            } else {
                left++;
                res[index--] = leftNum;
            }
        }

        return res;
    }

    public static int[] squaresSortedArrays_TwoPointer(int[] nums) {

        int mid = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            mid = i;
            if (nums[i] >= 0)
                break;
        }

        int L = mid - 1, R = mid;
        int[] arr = new int[n];
        int index = 0;
        while (0 <= L && R <= n - 1) {
            int Left = nums[L] * nums[L];
            int Right = nums[R] * nums[R];
            if (Left > Right) {
                arr[index] = Right;
                R++;
            } else {
                arr[index] = Left;
                L--;
            }
            index++;
        }

        while (0 <= L) {
            arr[index++] = nums[L] * nums[L];
            L--;
        }

        while (R <= n - 1) {
            arr[index++] = nums[R] * nums[R];
            R++;
        }

        return arr;
    }

    public static void squaresSortedArrays_BruteForce(int[] arr) {

        /*for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * arr[i];
        }*/

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (Math.abs(arr[j]) < Math.abs(arr[i])) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

            arr[i] = arr[i] * arr[i];

        }


    }
}