package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        final List<String> strings = generateParenthesis(n);
        System.out.println(strings);

    }


    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int openCount, int closeCount, int max) {
        if (openCount > max || closeCount > max) {
            return;
        }
        if (openCount == max && closeCount == max) {
            ans.add(cur.toString());
            return;
        }


        if (openCount < max) {
            cur.append("(");
            backtrack(ans, cur, openCount + 1, closeCount, max);
            //backtracking
            cur.deleteCharAt(cur.length() - 1);

        }

        if (openCount > closeCount) {
            cur.append(")");
            backtrack(ans, cur, openCount, closeCount + 1, max);
            //backtracking
            cur.deleteCharAt(cur.length() - 1);

        }
    }

}
