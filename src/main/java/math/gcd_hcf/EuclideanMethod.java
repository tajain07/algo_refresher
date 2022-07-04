package math.gcd_hcf;

public class EuclideanMethod {
    public static void main(String[] args) {
        System.out.println(gcd(4,8));
    }

    public static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
