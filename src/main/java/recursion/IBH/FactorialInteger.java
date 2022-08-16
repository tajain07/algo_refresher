package recursion.IBH;

public class FactorialInteger {
    public static void main(String[] args) {
        int n = 5;
        int fact = factorial(n);
        System.out.println("factorial of num " + n + " ==> " + fact);
    }

    private static int factorial(int n) {
        if (n == 1)
            return 1;

        return factorial(n - 1) * n;
    }


}
