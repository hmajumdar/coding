package com.leet;

public class powerIterative {

      private static double myPow1(double x, int n) {

        if (n == 0) {
            return 1;
        }

        long abs = Math.abs((long)n);
        double result = 1;

        while(abs > 0) {

            if(abs%2 != 0) {
                result *= x;
            }
            x *= x;
            abs /= 2;

        }

        if (n < 0) {
            return 1.0 / result;
        }

        return result;
    }

    public static void main(String args[]) {

        System.out.println(myPow1(2, 5));
//        System.out.println("Answer");
//        System.out.println(myPow(2, -2));
    }
}