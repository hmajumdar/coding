package binarysearch;

/**
 * Created by hmajumdar on 4/4/18.
 */

// Pivot element less than prev and next
public class RotatedArrayCount {

    public static int count(int []a) {

        int start = 0;
        int n = a.length;
        int end =  n - 1;
        int mid;
        int prev;
        int next;

        while(start <= end) {
            mid = start + (end - start) / 2;
            next = (mid + 1) % n;
            prev = (mid - 1 + n) % n;
            if (a[start] <= a[end]) {
                return start;
            } else if (a[start] >= a[end] && a[mid] <= a[prev] && a[mid] <= a[next]) {
                return mid;
            } else if (a[mid] <= a[end]) {
                end = mid - 1;
            } else if (a[mid] >= a[start]) {
                start = mid + 1;
            }

        }
        return -1;
    }


    public static void main(String args[]) {

        int arr[] = { 31, 5};
        System.out.println("-->"+ count(arr));

    }



}
