package math.lcm;

import math.gcd_hcf.EuclideanMethod;

public class LCM {
    public static void main(String[] args) {
        System.out.println(lcm(2,7));
    }
    static int lcm(int a, int b){
        return a*b/ EuclideanMethod.gcd(a,b);
    }
}
