package recursion;

public class FirstUppercaseLetter {
    public static void main(String[] args) {
        String s = "Ggeeks";
        final int i = firstUppercaseLetter(s, 0);
        if(i == -1)
            System.out.println("No uppercase letter");
        else
            System.out.println(s.charAt(i));
        System.out.println();
    }

    private static int firstUppercaseLetter(String s, int n) {
        if (s.length() - 1 == n)
            return -1;
        char c = s.charAt(n);
        if (Character.isUpperCase(c))
            return n;
        return firstUppercaseLetter(s, ++n);
    }
}
