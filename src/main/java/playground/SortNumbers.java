package playground;

import java.util.Arrays;

public class SortNumbers {
    public static void main(String[] args) {
        int[] arr = new int[]{17, 25, -45, 35, 51, -18, 33, 41, 19, 10, 40, 25};
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int position = i + 1;
            //System.out.println("i " + position + " num " + arr[i]);
            System.out.print(arr[i] + " ");
        }
    }
}
