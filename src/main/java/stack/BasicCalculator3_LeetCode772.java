package stack;

/**
 * 772. Basic Calculator III
 * https://leetcode.com/problems/basic-calculator-iii/
 */
public class BasicCalculator3_LeetCode772 {
    public static void main(String[] args) {
        System.out.println("Hello");
        String s = "1+1"; //2
        s = "6-4/2";  //4
        s = "2*(5+5*2)/3+(6/2+8)"; // 21
        s = "(2+6*3+5-(3*14/7+2)*5)+3"; //-12
        s = "0";  //0
        int output = calculate(s);
        System.out.println("output =" + output);
    }

    public static int calculate(String s) {
        return 0;
    }
}
