package recursion;

//https://www.geeksforgeeks.org/recursive-programs-to-find-minimum-and-maximum-elements-of-array/

public class MaxMinSumInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 3, -5, -4, 8, 6};
        int[] minMax = minMax(arr);
        System.out.println("Min " + minMax[0] + " Max " + minMax[1]);
    }

    private static int[] minMax(int[] arr) {
        return minMax(arr, 0, arr[0], arr[0]);
    }

    private static int[] minMax(int[] arr, int index, int min, int max) {
        if (index == arr.length - 1) {
            return new int[]{min, max};
        }
        int newMin = Math.min(min, arr[index]);
        int newMax = Math.max(max, arr[index]);
        return minMax(arr, ++index, newMin, newMax);
    }
}
