package com.udemy.ds.sort;

public class SelectionSort {

    public static void selectionSort(int[] arr){
        for (int i = 0;i<arr.length;i++){
            int minIndex = i;
            for (int j = i+1;j< arr.length;j++){
             if (arr[j] < arr[minIndex]){
                 minIndex = j;
             }
            }
            if (minIndex !=i){
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    public static void main(String[] args) {
        int[] myArray= {4,2,6,5,1,3};
        selectionSort(myArray);
    }
}
