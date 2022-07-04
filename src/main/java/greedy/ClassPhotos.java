package greedy;

//https://www.algoexpert.io/questions

import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {

    private static boolean canTakeGroupPhoto(Integer[] redShirts, Integer[] blueShirts) {

        int length = redShirts.length;

        Arrays.sort(blueShirts, Collections.reverseOrder());
        Arrays.sort(redShirts, Collections.reverseOrder());


        Integer[][] row = new Integer[2][length];

        int backRowIndex = 0;
        int frontRowIndex = 0;

        if (blueShirts[length - 1] > redShirts[length - 1]) {
            row[1] = blueShirts;
            row[0] = redShirts;

        } else if (redShirts[length - 1] > blueShirts[length - 1]) {
            row[1] = redShirts;
            row[0] = blueShirts;

        } else
            return false;


        int index = 0;
        while (index < length) {
            if (row[0][index] >= row[1][index])
                return false;

            index++;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] redShirts = new Integer[]{5, 8, 1, 3, 4};
        Integer[] blueShirts = new Integer[]{5, 9, 2, 4, 5};

        boolean result = canTakeGroupPhoto(redShirts, blueShirts);
        System.out.println("result " + result);

    }
}
