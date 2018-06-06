package com.random;

public class SecondHighest2 {

    private static int second(int arr[])
    {
        int i, first, second;

        /* There should be atleast two elements */
        if (arr.length < 2)
        {
            System.out.print(" Invalid Input ");
            return -1;
        }

        first = second = Integer.MIN_VALUE;
        for (i = 0; i < arr.length ; i++)
        {
            /* If current element is smaller than
            first then update both first and second */
            if (arr[i] > first)
            {
                second = first;
                first = arr[i];
            }

            /* If arr[i] is in between first and
               second then update second  */
            else if (arr[i] > second && arr[i] != first)
                second = arr[i];
        }

       return second;
    }

    public static void main(String args[]) {

        int a[] = {100, 2, 5, 18, 21, 5, 11};

        System.out.println(second(a));


    }





}
