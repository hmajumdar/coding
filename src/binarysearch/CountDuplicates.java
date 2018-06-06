package binarysearch;

/**
 * Created by hmajumdar on 4/4/18.
 */
public class CountDuplicates {

    public static int search(int []a, int n, boolean first) {

        int start = 0;
        int end =  a.length - 1;
        int mid;
        int result = 1;

        // Instead of returning the result, reduce the search space when element is found, and have a temp variable to store the result.
        // If there is only one occurrence, the temp variable will still have that one until the search is complete.
        while(start <= end) {

            mid = start + (end - start) / 2;
            if(a[mid] == n) {
                result = mid;
                if (first) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (a[mid] > n) {
                end = mid - 1;
            } else if (a[mid] < n) {
                start = mid + 1;
            }

        }
        return result;
    }


    public static void main(String args[]) {

        int arr[] = { 4, 4, 5, 6, 7, 7, 7, 7, 7, 7, 9 };

        int first = search(arr, 7, true);
        int last = search(arr, 7, false);

        int count = (last - first) + 1;
        System.out.println("-->"+ count);

    }



}
