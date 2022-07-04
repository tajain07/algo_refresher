package recursion;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://www.geeksforgeeks.org/sum-triangle-from-array/
public class SumTriangle {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        triangleSum(arr);
    }

    private static void triangleSum(int[] arr) {
        if (arr.length < 1)
            return;

        int[] newArr = new int[arr.length - 1];

        for (int i = 0; i < arr.length - 1; i++) {
            newArr[i] = arr[i] + arr[i+1];
        }

        triangleSum(newArr);
        System.out.println(Arrays.toString(arr));

    }
}
