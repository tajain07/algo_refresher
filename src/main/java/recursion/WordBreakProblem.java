package recursion;

import java.util.ArrayList;
import java.util.List;

public class WordBreakProblem {
    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> dict = new ArrayList<>();
        dict.add("cats");
        dict.add("cat");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");

        final List<String> strings = wordBreak(dict.size(), dict, s);
        System.out.println(strings);

    }

    static List<String> wordBreak(int n, List<String> dict, String s) {
        List<String> ans = new ArrayList<>();
        solve(dict, s, ans, "");
        return ans;
    }

    static void solve(List<String> dict, String s, List<String> ans, String temp) {
        if (s.length() == 0) {
            ans.add(temp.substring(1));
            return;
        }
        for (String wordInDict : dict)
            if (wordInDict.charAt(0) == s.charAt(0) && wordInDict.equals(s.substring(0, wordInDict.length())))
                solve(dict, s.substring(wordInDict.length()), ans, temp + " " + wordInDict);
    }
}
