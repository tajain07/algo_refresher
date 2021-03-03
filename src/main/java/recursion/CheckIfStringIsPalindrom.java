package recursion;

public class CheckIfStringIsPalindrom {
    public static void main(String[] args) {
        String str = "kayak";
        boolean isPalindrome = checkIfPalindrome(str);
        System.out.println(isPalindrome);
    }

    //Kayak
    private static boolean checkIfPalindrome(String str) {

        final int lastIndex = str.length() - 1;
        if(str.charAt(0) == str.charAt(lastIndex)){
            String newStr = str.substring(1, lastIndex);
            System.out.println(newStr);
            return  true;
        }
        else{
            return false;
        }
    }
}
