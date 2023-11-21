package leetcode;

import java.util.Arrays;

public class Task4MergedArrays {
    public static void main(String[] args) {
//        int[] array1 = new int[]{1, 3};
        int[] array1 = new int[]{10, 9, 11, 2};
//        int[] array2 = new int[]{2};
        int[] array2 = new int[]{1, 3, 4};
        System.out.println(findMedianSortedArrays(array1, array2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0, m1 = 0, m2 = 0;

        // Find median.
        for (int count = 0; count <= (n + m) / 2; count++) {
            m2 = m1;
            if (i != n && j != m) {
                if (nums1[i] > nums2[j]) {
                    m1 = nums2[j++];
                } else {
                    m1 = nums1[i++];
                }
            } else if (i < n) {
                m1 = nums1[i++];
            } else {
                m1 = nums2[j++];
            }
        }

        // Check if the sum of n and m is odd.
        if ((n + m) % 2 == 1) {
            return (double) m1;
        } else {
            double ans = (double) m1 + (double) m2;
            return ans / 2.0;
        }
    }
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//
//        int sumLength = nums1.length + nums2.length;
//        int[] sumArray = new int[sumLength];
//        for (int i = 0; i < nums1.length; i++) {
//            sumArray[i] = nums1[i];
//
//        }
//        for (int i = 0; i < nums2.length; i++) {
//            System.out.println("i0: "+i);
//            sumArray[nums1.length + i] = nums2[i];
//        }
//        int[] sortSumArray = Arrays.stream(sumArray).sorted().toArray();
//        System.out.println(Arrays.toString(sortSumArray));
//
//        int i = sumLength % 2;
//        if (i == 0) {
//            return ((double) sortSumArray[sumLength / 2 - 1] + (double) sortSumArray[sumLength / 2]) / 2;
//        }
//        return (double) sortSumArray[sumLength / 2];
//    }

}
