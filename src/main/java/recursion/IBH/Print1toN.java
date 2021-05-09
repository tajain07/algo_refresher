package recursion.IBH;

public class Print1toN {
    public static void main(String[] args) {
        print(10);
    }

    static void print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        print(n - 1);
        System.out.print(n + " ");
    }
}
