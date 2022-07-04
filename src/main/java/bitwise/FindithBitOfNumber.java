package bitwise;

public class FindithBitOfNumber {
    public static void main(String[] args) {
        int n = 0;
        findIThBit(n, 4);
    }

    private static void findIThBit(int n, int i) {

        int mask = 1 << (i - 1);
        if ((n & mask) > 0)
            System.out.println("Is set");
        else
            System.out.println("Not set");

    }
}
