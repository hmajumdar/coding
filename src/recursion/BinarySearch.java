package com.ds.recursion;

public class BinarySearch {
    
    private static int search(int[] arr, int start, int stop, int val) {

        int mid = (start + stop) / 2;

        if (start > stop) { // start and stop are inc and dec each iteration, element cannot be found when they cross each other.
            return -1;
        }

        if (arr[mid] == val) {
            return mid;
        } else if (arr[mid] > val) {
            stop = mid - 1; // this can be optimize
            // NO TRIM array in recursive call
            // don't just call, have a RETURN statement
            return search(arr, start, stop, val);
        } else {
            start = mid + 1; // this can be optimize
            // don't just call, have a return statement to recursive call
            return search(arr, start, stop, val); // no need to trim array in recursive call
        }

        // return -1; -- Should not simply return - 1

    }

    public static void main(String args[]) {

        int []arr = {11, 23, 34, 38, 41, 53, 55, 61, 66 };

        // CLIENT SENDS start and stop first time;
        int result = search(arr, 0, arr.length - 1, 67);
        System.out.println(result);

    }


}
