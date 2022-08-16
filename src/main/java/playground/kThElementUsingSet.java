package playground;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class kThElementUsingSet {
    public static void main(String[] args) {
        int[] arr = { 12, 3, 5, 7, 19};
        int n = arr.length;
        int k = 3;

        //since counting starts from 0 so to find kth
        //element we need to reduce k by 1
        k--;


        //for storing elements in sorted form
        //in set we will use TreeSet
        Set<Integer> s = new TreeSet<>();

        //adding elements to set
        for (int i = 0; i < n; i++)
            s.add(arr[i]);

        //we need iterator method of Iterator
        //for the traversal
        Iterator<Integer> itr = s.iterator();

        while (k > 0) {
            final Integer next = itr.next();
            k--;
        }//itr points to the kth element in the set
        System.out.println(itr.next());
    }
}
