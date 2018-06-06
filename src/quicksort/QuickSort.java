package quicksort;

/**
 * Created by hmajumdar on 4/14/18.
 */
public class QuickSort {

    private static void quickSort(int a[], int st, int en) {

        if (st >= en){
            return; // Void method CAN have a return;
        }

        int pivot=0;

        pivot = partition(a, st, en);

        quickSort(a, pivot+1, en); // Does not return, only recurse

        quickSort(a, st, pivot-1);

    }

    private static int partition(int a[], int st, int en) {

        int pivot = a[st];
        int lt = st+1; // Bug: Left Pointer starts from 2nd element
        int rt = en;

        for (int i = st; i <= en; i++) {

            if (a[lt] <= pivot) {
                lt++;
            }
            if (a[rt] > pivot) {
                rt--;
            }
            if (lt < rt) {
                swap (a, lt, rt);
                // Swap Left and Right
            }
        }

        // Swap with Pivot index (st) not pivot itself and return
        swap (a, st, rt); // This was bug
        return rt;
    }

    private static int[] swap(int a[], int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        return a;
    }


    public static void main(String args[]) {

        int arr[] = {33, 9, 42, 5, 11, 8, 7};
        quickSort(arr, 0, 6);
        System.out.println("After:");
        for(int i: arr) {
            System.out.print(" " + i);
        }


    }


}
