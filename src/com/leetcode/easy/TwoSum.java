package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 7, 11, 15};
        //int[] nums = new int[]{0, 4, 3, 0};

        int[] twoSum = twoSumHashMap(nums, 18);
        for (int i : twoSum) {
            System.out.println(i);
        }
    }

    /**
     * O(n2) complexity
     *
     * @param nums
     * @param target
     * @return int[] of length 2
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] resultArr = new int[2];
        resultArr[0] = -1;
        resultArr[1] = -1;
        boolean isFound = false;
        for (int indexFirst = 0; indexFirst < nums.length; indexFirst++) {
            for (int indexSec = indexFirst + 1; indexSec < nums.length; indexSec++) {
                if ((nums[indexFirst] + nums[indexSec]) == target) {
                    resultArr[0] = indexFirst;
                    resultArr[1] = indexSec;
                    isFound = true;
                    break;
                }
            }
            if (isFound) {
                //exiting the loop is solution is find
                break;
            }
        }
        return resultArr;
    }

    /**
     * O(n) time complexity
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int complement = -1;
        for (int indexFirst = 0; indexFirst < nums.length; indexFirst++) {
              complement =   target - nums[indexFirst];
              if(map.containsKey(complement)){
                  return new int[] {indexFirst, map.get(complement)};
              }
              else{
                  map.put(nums[indexFirst], indexFirst);
              }
        }
        return new int[]{};
    }
}
