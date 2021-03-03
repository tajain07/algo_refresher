package recursion;

public class Test {
    public static void main(String[] args) {
        String str = "dad";
        boolean isPalindrome = checkIfPalindrome(str);
        System.out.println(isPalindrome);
    }

    //
    private static boolean checkIfPalindrome(String str) {

        if(str.length() == 0 || str.length()==1)
            return  true;

        final int lastIndex = str.length() - 1;
        if(str.charAt(0) == str.charAt(lastIndex)){
            String newStr = str.substring(1, lastIndex);
            return checkIfPalindrome(newStr);
        }

            return false;

    }
}
