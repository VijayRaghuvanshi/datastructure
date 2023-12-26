package com.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicates {


    public static void main(String[] args) {

        //System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
        System.out.println(removeDuplicates(new int[]{1,1,2}));
    }
    /*
    * this approach will work even for non-sorted array as well. However, it is not efficient enough for the
    *  use case when input array in sorted. Which was given in problem statement.
     */
    public static int removeDuplicates(int[] nums){
        int noOfUniqueElements = nums.length;
        if (noOfUniqueElements == 1)
            return noOfUniqueElements;

        for(int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;){
                if (nums[i]==nums[j] && nums[j] != 101){
                    noOfUniqueElements--;
                    for (int k=j+1;k<nums.length;k++){
                        nums[k-1] = nums[k];
                    }
                    nums[nums.length-1]=101;
                }else{
                    j++;
                }
            }
        }

        System.out.println("nums = " + Arrays.toString(nums));

        return noOfUniqueElements;
    }



    /*
    *
    * efficient approach for sorted array.
     */
    public static int removeDuplicatesEfficient(int[] nums){

        if(nums.length <=1){
            return nums.length;
        }
       // for (int i=0;i<nums)
        return 0;

    }
}