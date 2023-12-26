package com.leetcode.easy;

import java.util.Arrays;

public class SearcgString {
    public static void main(String[] args) {

        System.out.println(searchInsert(new int[] {1,3},2));
        System.out.println(searchInsert(new int[] {1,3,5,6},5));
        System.out.println(searchInsert(new int[] {1,3,5,6},7));
        System.out.println(searchInsert(new int[] {1,3,5,6},0));
        System.out.println(searchInsert(new int[] {1,3,5,6},1));

    }

    public static int searchInsert(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        int median = -1;
        if (target <= nums[start] ){
            return start;
        } else if ( target == nums[end]){
            return end;
        } else if ( target > nums[end]){
            return end+1;
        }
        for (int i = start; start <= end ; ){
            if (nums[start] == target){
                return start;
            }else if ( nums[end] == target){
                return end;
            } else if ( start==end){

                return target > nums[start]?start+1:start;
            }
            else {
                median =  Math.abs(end+start)/2;
                if(target == nums[median]){
                    return median;
                }
                if ( target < nums[median]){
                    start = start+1;
                    end = median-1;
                }
                if (target > nums[median]){
                    start = median+1;
                    end = end;
                }
            }
        }
        System.out.println("num not found start:"+start+", end: "+end);
        if(start > end){
            index = target > nums[start]? start+1:end+1;
        }else  {
            index = target > nums[end]? end+1:start+1;
        }
        return index;
    }
}
