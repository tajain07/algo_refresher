package playground;

public class PrimitiveVsObject {
    public static void main(String[] args) {
        long lStart = 0;
        long lEnd = 0;
        long lMaxSize = 1000000000; // 1 billion.

        // Primitive data type
        System.out.print("Primitive data type runtime: ");
        lStart = System.currentTimeMillis();
        for (long i = 0; i < lMaxSize; i++) {
            long test = i;
        }
        lEnd = System.currentTimeMillis();
        System.out.println(lEnd - lStart);
        // Output: Primitive data type runtime: ~2454


        // Object data type
        System.out.print("Object data type runtime: ");
        lStart = System.currentTimeMillis();
        for (int i = 0; i < lMaxSize; i++) {
            Integer test = new Integer(i);
        }
        lEnd = System.currentTimeMillis();
        System.out.println(lEnd - lStart);
        // Output: Object data type runtime: ~106593

    }
}
