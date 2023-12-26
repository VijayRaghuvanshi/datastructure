package com.udemy.ds.sort;

public class ArrayProblems {

    public static void rotate(int[] nums, int k){
        return;
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static int[] findMinMax(int[] array){

        int min = array[0];
        int max = array[0];
        for (int i=1;i<array.length;i++){

            min = Math.min(min,array[i]);
            max = Math.max(max, array[i]);
        }
        return new int[]{max,min};

    }

    public static String findLongestString(String[] stringList){
        String longestString = "";
        for (String str: stringList){

            if (str.length() > longestString.length()){
                longestString = str;
            }
        }
        return longestString;
    }

    public static int removeDuplicates(int[] nums){
        if (nums.length < 1){
            return 0;
        }
        int duplicateIndex= 0;
        int uniqueIndex = 0;
        int length = 1;
        for (int i = 1; i<nums.length;i++){
            if (nums[uniqueIndex] != nums[i]){
                if (uniqueIndex < (i-1)){
                    nums[uniqueIndex+1] = nums[i];
                }
                uniqueIndex = i;
                length++;
            }
        }

        return length;
    }
}
