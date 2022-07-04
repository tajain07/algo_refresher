package two_pointer;

/**
 * https://www.geeksforgeeks.org/container-with-most-water/
 * <p>
 * https://leetcode.com/problems/container-with-most-water/
 * <p>
 * https://youtu.be/P1VeKzXfY-k
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {
        //int arr[] = new int[]{1, 5, 4, 3};
        int arr[] = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxWater = containerWithMostWater(arr);
        System.out.println("maxWater " + maxWater);
    }

    public static int containerWithMostWater(int[] arr) {
        int maxArea = Integer.MIN_VALUE, L = 0, R = arr.length - 1;
        while (L < R) {
            int area = (R - L) * Math.min(arr[L], arr[R]);
            maxArea = Math.max(area, maxArea);
            if (arr[L] < arr[R])
                L++;
            else
                R--;
        }
        return maxArea;
    }


}
