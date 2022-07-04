package math.square_root;

public class BinarySearchSQRT {
    public static void main(String[] args) {
        int number = 40;
        int precision_value = 3;
        System.out.printf("%.3f", sqrt(number, precision_value));
    }

    //O(log(n))
    private static double sqrt(int number, int precision_value) {
        int start = 0;
        int end = number;
        double root = 0.0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid * mid == number) {
                return mid;
            }
            if (mid * mid > number) {
                end = mid - 1;
            } else {
                start = mid + 1;
                root = mid;
            }
        }

        double increment = 0.1;
        for (int i = 0; i < precision_value; i++) {
            while (root * root <= number) {
                root += increment;
            }

            //one increment is extra because it made root*root <= number
            //so need to deduct that
            root -= increment;
            //reduce increment to reach correct precision point
            increment /= 10;
        }
        return root;
    }
}
