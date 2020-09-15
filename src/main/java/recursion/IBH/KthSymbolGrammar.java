package recursion.IBH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthSymbolGrammar {
    public static void main(String[] args) {
        int result = solve(4, 2);
        System.out.println(result);
    }

    public  int kthGrammar(int N, int K) {
        return kthGrammarHelper(N, K).get(K - 1);
    }

    //TODO - check if K value is already present no need to go down in recursion
    //
    public  List <Integer> kthGrammarHelper(int N, int K) {

        if (N == 0) {
            return new ArrayList <>(Arrays.asList(0));
        }

        List <Integer> returnVal = kthGrammarHelper(N - 1, K);
        List <Integer> newReturnVal = new ArrayList <>();

        for (int val : returnVal) {
            if (val == 0) {
                newReturnVal.add(0);
                newReturnVal.add(1);
            } else {
                newReturnVal.add(1);
                newReturnVal.add(0);
            }
        }

        return newReturnVal;

    }

    public static int solve(int N, int K) {

        if (N == 1 && K == 1)
            return 0;

        int mid = (int) (Math.pow(2, (N - 1)) )/2;

        if (K <= mid) {
            return solve(N - 1, K);
        } else {
            return solve(N - 1, K - mid) == 0 ? 1 : 0;

        }

    }
}
