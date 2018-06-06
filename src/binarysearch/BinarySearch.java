package binarysearch;

/**
 * Created by hmajumdar on 4/4/18.
 */
public class BinarySearch {

    public static int search(int []a, int n) {

        int start = 0;
        int end =  a.length - 1;
        int mid;

        while(start <= end) {

            mid = start + (end - start) / 2;
            if(a[mid] == n) {
                return mid;
            } else if (a[mid] > n) {
                end = mid - 1;
            } else if (a[mid] < n) {
                start = mid + 1;
            }

        }
        return -1;
    }


    public static void main(String args[]) {

        int arr[] = { 33, 42, 5, 6, 7, 9, 12, 18, 22, 27 };
        System.out.println("-->"+ search(arr, 5));

    }



}
