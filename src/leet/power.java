package com.leet;

public class power {

    private static double myPow(double x, int n) {

        if(n>0) {
            return myPow1(x, n);
        } else {
            return 1/myPow1(x, n);
        }

    //        return (1 / x) * (1 / (myPow(x, n + 1))); ==> 1/2 * 1/(1/2) => DELEGATE TO ANOTHER METHOD

    }

    private static double myPow1(double x, int n) {

        if (n == 0) {
            return 1;
        }

        if (n % 2 == 0) {
            return myPow(x, n / 2) * myPow(x, n / 2);
        } else {
            return x * myPow(x, n / 2) * myPow(x, n / 2);
        }

    }

    public static void main(String args[]) {

        System.out.println(myPow(0.00001, 2147483647));
//        System.out.println("Answer");
//        System.out.println(myPow(2, -2));
    }
}