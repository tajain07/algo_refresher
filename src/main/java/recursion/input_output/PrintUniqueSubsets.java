package recursion.input_output;

import java.util.*;

public class PrintUniqueSubsets {
    public static void main(String[] args) {
        String input = "aab";
        String output = "";
        Set <String> subsSets = new HashSet <>();
        getAllSubSets(input, output, subsSets);

        System.out.println("unordered set " + subsSets);

        List <String> orderedSubSets = new ArrayList <>(subsSets);
        Collections.sort(orderedSubSets);
        System.out.println("orderedSubSets " + orderedSubSets);

    }

    private static void getAllSubSets(String input, String output, Set <String> subsSets) {
        if (input.length() == 0) {
            subsSets.add(output);
            return;
        }

        String output2 = output + input.charAt(0);
        input = input.substring(1);

        getAllSubSets(input, output, subsSets);
        getAllSubSets(input, output2, subsSets);
    }
}
