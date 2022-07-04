package bitwise;

public class OddOrEven {
    public static void main(String[] args) {
        int n = 68;
        boolean ans = isOddOrNot(n);
        System.out.println("isOdd "+ans);
    }

    private static boolean isOddOrNot(int n) {
        return (n & 1) == 1;
    }
}
