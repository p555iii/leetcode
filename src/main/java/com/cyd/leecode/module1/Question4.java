package com.cyd.leecode.module1;

import java.util.Arrays;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Question4 {
    public static void main(String[] args) {
        int[] num1 = {1,2,3};
        int[] num2 = {5,6,7};
        System.out.println(findMedianSortedArrays(num2,num1));
    }

    /**
     * 我的思路是将两个数组先拼成一个大数组，然后排序，在通过%2是否为0来判断中位数是 一个值还是两个值相加/2
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int num1Length = nums1.length;
        int num2Length = nums2.length;
        double res = 0;
        int sumLength = num1Length + num2Length;
        int[] sumArr = new int[sumLength];
        for(int i = 0;i<num1Length;i++){
            sumArr[i]=nums1[i];
        }
        for(int j = 0;j < num2Length;j++){
            sumArr[j+num1Length] = nums2[j];
        }
        Arrays.sort(sumArr);
        int flag = sumLength % 2;
        if(flag == 0){
            double s = (double)sumArr[sumLength/2-1]+sumArr[sumLength/2];
            res = s/2;
        }else {
            res= sumArr[sumLength/2];
        }
        return res;
    }
}
