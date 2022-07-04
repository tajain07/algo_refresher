package binary_search;

/**
 * Leetcode - 69
 * https://leetcode.com/problems/sqrtx/
 */
public class SquareRoot_LC69 {
    public static void main(String[] args) {

        System.out.println(mySqrt(0));
        System.out.println(mySqrtBinarySearch2(0));
        System.out.println(mySqrtBinarySearch2(0));


        System.out.println(mySqrt(2));
        System.out.println(mySqrtBinarySearch2(2));
        System.out.println(mySqrtBinarySearch2(2));


        System.out.println(mySqrt(8));
        System.out.println(mySqrtBinarySearch2(8));
        System.out.println(mySqrt_SDESKills(8));
        System.out.println(sqrt2(8));

        System.out.println(mySqrt(2147483647));
        System.out.println(mySqrtBinarySearch2(2147483647));
        System.out.println(mySqrt_SDESKills(2147483647));
        System.out.println(sqrt2(2147483647));


        System.out.println(mySqrt(1));
        System.out.println(mySqrtBinarySearch2(1));
        System.out.println(mySqrt_SDESKills(1));
        System.out.println(sqrt2(1));

        System.out.println(mySqrt(2147395599));
        System.out.println(mySqrtBinarySearch2(2147395599));
        System.out.println(mySqrt_SDESKills(2147395599));
        System.out.println(sqrt2(2147395599));

    }

    /**
     * First we need to search for minimal k satisfying condition k^2 > x, then k - 1 is the answer to the question.
     * We can easily come up with the solution. Notice that I set right = x + 1 instead of right = x to deal with
     * special input cases like x = 0 and x = 1.
     *
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x < 2) return x;
        long num;
        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;
            num = (long) mid * mid;
            if (num > x)
                right = mid;
            else
                left = mid + 1;

        }
        return left - 1;

    }

    public static int mySqrtBinarySearch2(int x) {
        if (x < 2) return x;

        long num;
        int left = 2, right = x / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //System.out.println(mid);
            num = (long) mid * mid;
            if (num > x)
                right = mid - 1;
            else if (num < x)
                left = mid + 1;
            else
                return mid;
        }
        return right;

    }

    public static int mySqrt_SDESKills(int x) {
        if (x == 0)
            return 0;
        int lo = 1, hi = x;
        while (hi - lo > 1) {
            int mid = lo + (hi - lo) / 2;
            if (ok(x, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static boolean ok(int x, int mid) {
        return mid <= x / mid;
    }

    //https://labuladong.gitbook.io/algo-en/iii.-algorithmic-thinking/detailedbinarysearch
    //right_bound
    //TTT'T'FFFF
    private static int sqrt2(int target) {
        if (target < 2)
            return target;

        int left = 0, right = target - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid < target / mid) {
                left = mid + 1;
            } else if (mid > target / mid) {
                right = mid - 1;
            } else if (mid == target / mid) {
                // Don't return! Lock right border
                left = mid + 1;
            }
        }

        if (right < 0 || right > target / right)
            return -1;
        return right;

    }
}
