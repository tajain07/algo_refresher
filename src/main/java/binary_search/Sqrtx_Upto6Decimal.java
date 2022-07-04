package binary_search;

public class Sqrtx_Upto6Decimal {

    public double mySqrt_6Decimal(int x) {
        if (x == 0)
            return 0;
        double lo = 1, hi = x, epsilon = 10e-6;
        while (hi - lo > epsilon) {
            double mid = lo + (hi - lo) / 2;
            if (ok(x, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public double mySqrt_6Decimal2(int x) {
        if (x == 0)
            return 0;
        double lo = 1, hi = x, epsilon = 10e-6;
        //while (hi - lo > epsilon) {
        for (int i = 0; i < 80; i++) {
            double mid = lo + (hi - lo) / 2;
            if (ok(x, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private boolean ok(int x, double mid) {
        return mid <= x / mid;
    }


    public static void main(String[] args) {
        Sqrtx_Upto6Decimal sqrtx = new Sqrtx_Upto6Decimal();
        System.out.println(sqrtx.mySqrt_6Decimal2(8));
        System.out.println(sqrtx.mySqrt_6Decimal(8));
    }
}
