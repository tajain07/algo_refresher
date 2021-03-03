package recursion;

public class IsStringPalindrome {
    public static void main(String[] args) {
        String input = "kayak";
        boolean result = isPalindrome(input);
        System.out.println(result);
    }


    static boolean isPalindrome(String inputStr) {
        if (inputStr.length() == 1 || inputStr.isEmpty()) {
            return true;
        }

        int lastIndex = inputStr.length() - 1;

        if (inputStr.charAt(0) == inputStr.charAt(lastIndex))
            return isPalindrome(inputStr.substring(1, inputStr.length() - 1));
        else
            return false;
    }
}
