package math.factors;

import java.util.ArrayList;
import java.util.List;

public class Factors {
    public static void main(String[] args) {
        int n = 36;
        factors1(n);
        factors2(n);
        factors3(n);
    }

    //O(n)
    static void factors1(int n) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    //O(sqrt(n))
    static void factors2(int n) {
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n / i == i) {
                System.out.print(i + " ");

            } else if (n % i == 0)
                System.out.print(i + " " + n / i + " ");
        }
        System.out.println();

    }


    //Sorted order
    static void factors3(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n / i == i) {
                System.out.print(i + " ");

            } else if (n % i == 0) {
                System.out.print(i + " ");
                list.add(n / i);
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();
    }
}
