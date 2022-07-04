package two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        //String s = "caedbdedda";
        String s = "ababcbacadefegdehijhklij";
        //List<Integer> output = partitionLabelsFirstAttempt(s);
        List<Integer> output = partitionLabels_Optimized(s);
        System.out.println("output " + output);
    }

    public static List<Integer> partitionLabels_Optimized(String s) {
        char[] arr = s.toCharArray();
        int[] cache = new int[128];
        for (int i = 0; i < arr.length; i++) {
            char cur = arr[i];
            cache[cur] = i;
        }
        int L = 0, R = 0, index = 0;
        List<Integer> res = new LinkedList<>();
        while (index < arr.length) {
            char cur = arr[index];
            R = Math.max(R, cache[cur]);
            if (R == index) {
                int size = R - L + 1;
                res.add(size);
                R++;
                L = R;
            }
            index++;
        }
        return res;
    }

    public static List<Integer> partitionLabelsFirstAttempt(String s) {
        List<Integer> result = new ArrayList<>();

        int[][] startEndIndices = new int[26][2];
        final char[] chars = s.toCharArray();

        for (int[] subArray : startEndIndices) {
            Arrays.fill(subArray, -1);
        }

        for (int i = 0; i < chars.length; i++) {
            final int index = chars[i] - 'a';
            if (startEndIndices[index][0] == -1) {
                startEndIndices[index][0] = i;
                startEndIndices[index][1] = i;
            } else {
                startEndIndices[index][1] = i;
            }
        }


        int startIndex = startEndIndices[chars[0] - 'a'][0];
        int endIndex = startEndIndices[chars[0] - 'a'][1];


        for (int i = 0; i < chars.length; i++) {
            int charIndex = chars[i] - 'a';
            final int tempCharStartIndex = startEndIndices[charIndex][0];
            final int tempCharEndIndex = startEndIndices[charIndex][1];

            if (tempCharStartIndex > endIndex && tempCharEndIndex > endIndex) {

                result.add(endIndex - startIndex + 1);

                startIndex = tempCharStartIndex;
                endIndex = tempCharEndIndex;

            } else if (tempCharEndIndex > endIndex) {
                endIndex = tempCharEndIndex;
            }

        }

        result.add(endIndex - startIndex + 1);
        return result;

    }

}
