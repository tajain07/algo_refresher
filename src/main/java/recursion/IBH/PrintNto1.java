package recursion.IBH;

public class PrintNto1 {
    public static void main(String[] args) {
        print(10);
    }

    static void print(int n){

        if(n ==1 ){
            System.out.print(n+" ");
            return;
        }
        System.out.print(n+" "); //
        print(n-1);
    }
}
