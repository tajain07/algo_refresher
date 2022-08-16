package recursion.IBH;

import java.util.LinkedList;
import java.util.List;

public class JosephusProblem {
    public static void main(String[] args) {
        int n = 40;
        int k = 7;
        int lastPersonStanding = getLastPerson(n, k);
        System.out.println("lastPersonStanding " + lastPersonStanding);
    }

    private static int getLastPerson(int n, int k) {
        List<Integer> persons = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            persons.add(i);
        }

        return getLastPersonHelper(0, persons, k);


    }

    private static int getLastPersonHelper(int index, List<Integer> persons, int k) {
        int n = persons.size();
        if (persons.size() == 1) {
            return persons.get(0);
        }

        index = (index + k - 1) % n;
        persons.remove(index);
        return getLastPersonHelper(index, persons, k);
    }

}
