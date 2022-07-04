package binary_search;

public class FirstPositionOf1 {
    public static void main(String[] args) {
        System.out.println(firstPositionOf1(new int[]{0, 0, 0, 0, 0, 1, 1, 1}));
        System.out.println(firstPositionOf1(new int[]{1, 1, 1, 1, 1, 1, 1, 1}));

    }

    private static int firstPositionOf1(int[] ints) {
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (ints[mid] == 1) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
