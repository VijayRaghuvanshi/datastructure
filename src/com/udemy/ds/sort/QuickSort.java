package com.udemy.ds.sort;

public class QuickSort {
    public static int pivot(int[] array, int pivotIndex, int endIndex){

        int pivotEle = array[pivotIndex];
        int swapIndex = pivotIndex;
        for (int i=pivotIndex+1; i<=endIndex;i++){
            if(array[i] < pivotEle){
                swapIndex++;
                swap(array, swapIndex,i);
            }
        }
        swap(array,pivotIndex,swapIndex);
        return swapIndex;
    }

    public static void quickSortHelper(int[] array, int left, int right){
        if (left > right){
            return;
        }
        int pivot = pivot(array, left, right);
        quickSortHelper(array,left, pivot-1);
        quickSortHelper(array, pivot+1, right);

    }

    private static void swap(int[] array, int firstIndex, int secondIndex) {
        int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

}
