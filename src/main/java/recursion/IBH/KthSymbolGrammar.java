package recursion.IBH;

import java.util.ArrayList;
import java.util.List;

public class KthSymbolGrammar {
    public static void main(String[] args) {
        int N = 4;
        int k = 3;
        int result = kthGrammar_Approach1(N, k);
        System.out.println(result);

        result = kthGrammar_Approach2(N, k);
        System.out.println(result);

    }

    public static int kthGrammar_Approach1(int N, int K) {

        if (N == 1 && K == 1)
            return 0;

        //Number of digits =
        //N=1 => 0  => 2^0
        //N=2 => 01 => 2^1
        //N=3 => 0110 => 2^2
        int numberOfDigits = (int) (Math.pow(2, (N - 1)));
        int mid = numberOfDigits / 2;

        if (K <= mid) {
            return kthGrammar_Approach1(N - 1, K);
        } else {
            return kthGrammar_Approach1(N - 1, K - mid) == 0 ? 1 : 0;

        }

    }


    public static int kthGrammar_Approach2(int N, int K) {
        return kthGrammarHelper(N, K).get(K - 1);
    }

    //TODO - check if K value is already present no need to go down in recursion
    //
    public static List<Integer> kthGrammarHelper(int N, int K) {

        if (N == 1) {
            return new ArrayList<>(List.of(0));
        }

        List<Integer> returnVal = kthGrammarHelper(N - 1, K);
        List<Integer> newReturnVal = new ArrayList<>();

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


}
