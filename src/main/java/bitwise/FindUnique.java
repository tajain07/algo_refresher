package bitwise;

public class FindUnique {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(uniqueNumber(arr));
    }

    private static int uniqueNumber(int[] arr) {
        int unique = 0;

        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }
}
