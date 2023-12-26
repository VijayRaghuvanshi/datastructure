package com.leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {

        /*int[] num1 = new int[]{1,2,3,0,0,0};
        int[] num2 = new int[]{1,2,3};
        merge(num1,3,num2,3);
        for (int i:num1) {
            System.out.println(i);
        }*/

        int[] num1 = new int[]{0};
        int[] num2 = new int[]{1};
        merge(num1,0,num2,1);
        for (int i:num1) {
            System.out.println(i);
        }

    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null || nums2==null || n==0 ){
            return;
        }
        if (m==0){
            for (int i=0;i<n;i++){
                nums1[i]=nums2[i];
            }
            return;
        }


        int[] temp = nums1.clone();
        for (int i=0,j=0,t=0; j< n && i<nums1.length; ){
            if (nums2[j] <= temp[t]){
                nums1[i]=nums2[j];
                nums1[i+1]=temp[t];
                i+=2;
                j++;
                t++;
            } else if (nums2[j] > nums1[i] && temp[t]==0){
                nums1[i]=nums2[j];
                i++;
                j++;
                t++;
            }else if (nums2[j] > nums1[i]){
                i++;
            }
        }
        return;
    }
}
