package com.udemy.ds.sort;

public class BubbleSort {

    public static void bubbleSort(int[] arr){

        for (int i= arr.length-1;i<=1;i-- ){
            for (int j=0;j<=i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                }
            }
        }

    }
}
