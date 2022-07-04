package recursion;

public class ReverseANumber {
    public static void main(String[] args) {
        int n = reverseANumber(1234);
        System.out.println(n);
    }

    private static int reverseANumber(int num) {

        if (num % 10 == num)
            return num;

        int digits = ((int) Math.log10(num));

        return ((num % 10) * (int) Math.pow(10, digits) + reverseANumber(num / 10));
    }


}
