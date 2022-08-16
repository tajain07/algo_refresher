package recursion.IBH;

import java.util.concurrent.atomic.AtomicInteger;

//  I A
//  I B
//  I C
//--------


//Time compelxity - O(2^n)
//https://www.youtube.com/watch?v=VC4V67q2kEk&ab_channel=BasicsStrong
public class TowerOfHanoi {
    public static void main(String[] args) {
        int NoOfPlates = 3;
        String s = "source";
        String h = "helper";
        String d = "destination";

        AtomicInteger numberOfSteps = new AtomicInteger(0);
        printTowerOfHanoiSteps(NoOfPlates, s, d, h, numberOfSteps);
        System.out.println("numberOfSteps " + numberOfSteps);
    }

    public static Character getPlateName(int n) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final Character c = s.charAt(n - 1);
        return c;
    }

    private static void printTowerOfHanoiSteps(int noOfPlates, String source, String destination, String helper, AtomicInteger numberOfSteps) {

        numberOfSteps.getAndIncrement();

        if (noOfPlates == 1) {
            System.out.println("Moving " + getPlateName(noOfPlates) + " plate  from " + source + " to " + destination);
            return;
        }

        printTowerOfHanoiSteps(noOfPlates - 1, source, helper, destination, numberOfSteps);

        System.out.println("Moving " + getPlateName(noOfPlates) + " plate  from " + source + " to " + destination);

        printTowerOfHanoiSteps(noOfPlates - 1, helper, destination, source, numberOfSteps);
    }

}
