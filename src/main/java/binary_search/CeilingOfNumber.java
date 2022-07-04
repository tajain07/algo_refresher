package binary_search;

//ceiling - smallest element in array greater or = target
// https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/

public class CeilingOfNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 9, 14, 16, 18};
        int target = 13;

        //ceiling(arr, target=14) = 14
        //ceiling(arr, target=15) = 16
        //ceiling(arr, target=4) = 5
        //ceiling(arr, target=9) = 9
        //ceiling(arr, target=19) = -1
        System.out.println(ceiling(arr, 14, 0, arr.length - 1));
        System.out.println(ceiling(arr, 16, 0, arr.length - 1));
        System.out.println(ceiling(arr, 17, 0, arr.length - 1));
        System.out.println(ceiling(arr, 4, 0, arr.length - 1));
        System.out.println(ceiling(arr, 8, 0, arr.length - 1));
        System.out.println(ceiling(arr, -1, 0, arr.length - 1));
        ;
    }


    static int ceiling(int[] arr, int target, int s, int e) {
        if (target > arr[arr.length - 1])
            return -1;

        int m = s + (e - s) / 2;

        while (s <= e) {
            if (arr[m] == target)
                return m;

            if (arr[m] > target)
                return ceiling(arr, target, s, m - 1);


            return ceiling(arr, target, m + 1, e);
        }

        return s;
    }
}
