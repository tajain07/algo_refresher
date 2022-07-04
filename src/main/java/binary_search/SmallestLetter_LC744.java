package binary_search;

//https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class SmallestLetter_LC744 {

    public static void main(String[] args) {
        char answer = nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'f', 'g'}, 'e');
        System.out.println("answer " + answer);
    }


    static char nextGreatestLetter(char[] letters, char target) {

        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] == target)
                start = mid + 1;
            if (letters[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return letters[start % letters.length];
    }

}
