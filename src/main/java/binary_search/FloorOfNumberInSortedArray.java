package binary_search;

//floor - greatest number smaller or = target
public class FloorOfNumberInSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 5, 9, 14, 16, 18};

        //floor(arr, target=14) = 14
        //floor(arr, target=15) = 14
        //floor(arr, target=4) = 3
        //floor(arr, target=9) = 9
        System.out.println("floor(arr, target=15) = 4 " + floor(arr, 15, 0, arr.length - 1));

        System.out.println("floor(arr, target=14) = 4 " + floor(arr, 14, 0, arr.length - 1));
        System.out.println("floor(arr, target=4) = 1 " + floor(arr, 4, 0, arr.length - 1));
        System.out.println("floor(arr, target=9) = 3 " + floor(arr, 9, 0, arr.length - 1));
        System.out.println("floor(arr, target=1) = -1 " + floor(arr, 1, 0, arr.length - 1));

    }


    static int floor(int[] arr, int target, int s, int e) {

        while (s <= e) {
            int m = s + (e - s) / 2;

            if (arr[m] == target)
                return m;

            if (arr[m] > target) {
                //return floor(arr, target, s, m - 1);
                e = m - 1;
            } else {
                s = m + 1;
                //return floor(arr, target, m + 1, e);

            }
        }

        return e;
    }
}
