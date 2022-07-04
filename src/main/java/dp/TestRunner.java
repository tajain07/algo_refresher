package dp;

import java.util.Collection;

public class TestRunner<T> {
    public static <T> void runTestCase(T expected, T actual) {
        if (actual.equals(expected)) {
            System.out.println("Testcase --> actual [" + actual + "] == expected [" + expected + "] --- PASS!");

        }else{
            System.out.println("Testcase --> actual [" + actual + "] != expected [" + expected + "] --- FAIL!");

        }
    }
}
