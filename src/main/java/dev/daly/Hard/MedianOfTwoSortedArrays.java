package dev.daly.Hard;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    //Brute force method, not meeting time complexity requirements which is O(log(m+n))
    //The time complexity is O(m+n) because we are iterating through both arrays
    //The space complexity is O(m+n) because we are creating a new array to store the values of both arrays

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
        System.out.println(findMedianSortedArrays(new int[]{0,0}, new int[]{0,0}));
        System.out.println(findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, nums3, 0, nums1.length);
        System.arraycopy(nums2, 0, nums3, nums1.length, nums2.length);
        Arrays.sort(nums3);
        if(nums3.length % 2 == 0) {
            int middle = nums3.length / 2;
            int middle2 = middle - 1;
            return (double) (nums3[middle] + nums3[middle2]) / 2;
        }
        return (double) nums3[nums3.length / 2];
    }

}
