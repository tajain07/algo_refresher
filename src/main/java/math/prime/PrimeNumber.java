package math.prime;

public class PrimeNumber {
    public static void main(String[] args) {
        int n = 40;
        for (int i = 2; i <= n; i++) {
            if(i %2 !=0)
            System.out.println(i + " " + isPrime(i));
            else
                System.out.println(i + " " + false);

        }
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        int c = 2;
        while (c * c <= n) {
            if (n % c == 0)
                return false;
            c++;
        }

        return true;
    }
}
