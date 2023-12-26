package com.udemy.ds.sort;

import java.util.Arrays;

public class MergeSort {

    private static int[] merge(int[] left, int[] right){
        int[] combined = new int[left.length+right.length];
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length){
            if (left[leftIndex] < right[rightIndex]){
                combined[index] = left[leftIndex];
                index++;
                leftIndex++;
            }else {
                combined[index] = right[rightIndex];
                index++;
                rightIndex++;
            }
        }
        while (leftIndex < left.length){
            combined[index] = left[leftIndex];
            index++;
            leftIndex++;
        }

        while (rightIndex < right.length){
            combined[index] = right[rightIndex];
            index++;
            rightIndex++;
        }
        return combined;
    }

    public static int[] mergeSort(int[] arry){
        if (arry.length==1){
            return arry;
        }
         int midIndex =   arry.length/2;
         int[] left = mergeSort(Arrays.copyOfRange(arry,0,midIndex));
         int[] right = mergeSort(Arrays.copyOfRange(arry, midIndex,arry.length));
        return merge(left, right);
    }
}
