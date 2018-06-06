package com.homework;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {


    private static void printMaxfromEachSubarray(int arr[], int k) {

        // Strategy: Use dequeue to "store and track indices". Array will use the indices in deque to process its values.
        // Process first window separately. Keep discarding left smaller values.
        if(arr==null || arr.length <=0 || arr.length <=k) {
            System.out.println("Invalid Input");
            return;
        }

        int result[] = new int[arr.length-k+1];

        Deque<Integer> deque = new LinkedList<>();

        // Step-1: Keep Useful elements: Iterate thru the first Window and delete left most small elements compared to right
        for (int i=0; i<k; i++) {

            while(!deque.isEmpty() && arr[deque.getLast()] < arr[i] ) { // Check for empty lest before getting
                deque.removeLast();
            }
            deque.addLast(i); //Add to last
        }
        // Print the first element (highest for the first window)
        System.out.println(arr[deque.getFirst()]);
        result[0] = arr[deque.getFirst()];

        // Step2: In queue Start iterating from k
        for(int i=k; i<arr.length; i++) {

            while(!deque.isEmpty() && arr[deque.getLast()] < arr[i]) {
                deque.removeLast();
            }

            // Remove elements which are not part of the current window
            while(!deque.isEmpty() && deque.getFirst() < (i - k + 1)) {
                deque.removeFirst();
            }

            deque.addLast(i);

            result[i-k+1] = arr[deque.getFirst()];
            System.out.println(arr[deque.getFirst()]);
        }

        System.out.println(result);


    }


    public static void main(String[] args)
    {

//        int[] array = {11,6,9,8,10,5,14,13,93,14};
        int[] array = {2,15,15};
        int k = 2;

        System.out.println("Maximum elements from each sub-array of specified size are - ");
        printMaxfromEachSubarray(array, k);
    }



}
