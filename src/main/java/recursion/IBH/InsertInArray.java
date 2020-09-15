package recursion.IBH;

import java.util.ArrayList;
import java.util.List;

public class InsertInArray {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List <Integer> a = new ArrayList <Integer>();
        a.add(61);
        a.add(60);
        int element = 2;

        InsertInArray insertInArray = new InsertInArray();
        insertInArray.insert(a, 2);
        System.out.println(a);

    }

    void insert(final List <Integer> listOfNumbers, final int element) {

        int size = listOfNumbers.size();

        //Base condition
        if (size == 0 || listOfNumbers.get(size - 1) <= element) {
            listOfNumbers.add(element);
            return;
        }

        //Hypothesis
        int lastElement = listOfNumbers.get(size - 1);
        listOfNumbers.remove(size - 1);
        insert(listOfNumbers, element);

        //Induction
        listOfNumbers.add(lastElement);

    }
}
