package recursion.IBH;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        int n = 50;
        BigInteger fact = factorial(n);
        System.out.println("fact " + fact);

    }


    //n*n-1*n-2...
    //factorial(n-1)*n
    static BigInteger factorial(int n) {
        if (n == 1) {
            return BigInteger.valueOf(1);
        }

        BigInteger temp_fact = factorial(n - 1);
        return temp_fact.multiply(BigInteger.valueOf(n));
    }
}
