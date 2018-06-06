package mergesort;

/**
 * Created by hmajumdar on 5/12/18.
 */
public class Median {

    public static void findMedianSortedArrays(int[] nums1, int[] nums2) {

        if ((nums1 == null || nums1.length < 1) && (nums2 == null || nums2.length < 1)) {
            return;
        }

        int i = 0;
        int j = 0;
        int k = 0;


        int temp[] = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                temp[k] = nums1[i];
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
            }
            k++;
        }

        while (i < nums1.length) {
            temp[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            temp[k++] = nums2[j++];
        }

        System.out.println("Temp size: " + k);

        if (k%2 == 0) {
            double x1 = temp [(k / 2) - 1];
            double x2 = temp[k/2];
            double y = (x1 + x2) / 2;

            System.out.println("Even mergesort.Median: " + y);

        } else {
            System.out.println("Odd mergesort.Median: " + temp[k/2]);
        }


    }

    public static void main(String args[]) {

        int nums1[] = {3,4};
        int nums2[] = {1,2};
        findMedianSortedArrays(nums1, nums2);

    }


}

