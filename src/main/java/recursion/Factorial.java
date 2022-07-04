package recursion;

public class Factorial {
    public static void main(String[] args) {
        int n = 13;
        int x = factorial(n);
        System.out.println(x);
    }

    private static int factorial(int n) {
        if (n < 1)
            return 1;
        return n * factorial(n - 1);
    }
}
