package recursion.IBH;

import java.util.concurrent.atomic.AtomicInteger;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int NoOfPlates = 3;
        String s = "source";
        String h = "helper";
        String d = "destination";

        AtomicInteger numberOfSteps = new AtomicInteger(0);
        printTowerOfHanoiSteps(NoOfPlates, s, d, h, numberOfSteps);
        System.out.println("numberOfSteps "+numberOfSteps);
    }

    private static void printTowerOfHanoiSteps(int noOfPlates, String source, String destination, String helper, AtomicInteger numberOfSteps) {

        numberOfSteps.getAndIncrement();

        if (noOfPlates == 1) {
            System.out.println("Moving plate " + noOfPlates + " from " + source + " to " + destination);
            return;
        }

        printTowerOfHanoiSteps(noOfPlates - 1, source, helper, destination, numberOfSteps);

        System.out.println("Moving plate " + noOfPlates + " from " + source + " to " + destination);

        printTowerOfHanoiSteps(noOfPlates - 1, helper, destination, source, numberOfSteps);
    }

}
