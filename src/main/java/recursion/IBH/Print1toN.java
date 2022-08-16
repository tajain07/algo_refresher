package recursion.IBH;

public class Print1toN {
    public static void main(String[] args) {
        print(10);
        System.out.println();
        print2(10);
    }

    static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }


    static void print2(int n) {
        if (n == 0) {
            //System.out.print(n + " ");
            return;
        }
        print2(n - 1);
        System.out.print(n + " ");
    }
}
