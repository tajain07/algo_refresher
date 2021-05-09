package sliding_window.variable_size_sliding_window;

/**
 * John is at a toy store help him pick maximum number of toys.
 * He can only select in a continuous manner and he can select only two types of toys.
 * <p>
 * <p>
 * Example:
 * Input:
 * 1
 * abaccab
 * <p>
 * Output: max number of toys
 *
 * Largest Substring with K unique character - check LongestSubStringWithKUniqueCharacters
 */
public class PickToys {
    public static void main(String[] args) {
        String str = "abaccab";
        int k = 2; //max two type allowed

        int toyCount = maxNumberOfToys(str, k);
        System.out.println("toyCount "+ toyCount);
    }

    //LongestSubStringWithKUniqueCharacters
    public static int maxNumberOfToys(String str, int k) {
        return 0;
    }
}
