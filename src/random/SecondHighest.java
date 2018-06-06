package com.random;

public class SecondHighest {

    private static int second(int arr[]) {

        if(arr == null || arr.length <=1) {
            return -1;
        }

        int highest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int temp;


        for(int i=0; i < arr.length-1; i++) {

            if(arr[i] > highest) {
//                second = highest; : You may skip the temp swap below by adding this line!
                highest = arr[i];
            }

            else if (second < arr[i+1] && arr[i+1] != highest) { // arr[i+1] != highest for duplicate highest.
                second = arr[i+1];
            }

            if (highest < second) {
                temp = second;
                second = highest;
                highest = temp;
            }

        }

        return second;
    }


    public static void main(String args[]) {

        int a[] = {100, 2, 5, 31, 31, 18, 21, 5, 11};

        System.out.println(second(a));


    }





}
