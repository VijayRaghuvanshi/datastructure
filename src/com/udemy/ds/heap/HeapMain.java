package com.udemy.ds.heap;

import java.util.ArrayList;
import java.util.List;

public class HeapMain {
    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }

    public static List<Integer> streamMax(int[] nums){
        Heap heap = new Heap();
        List<Integer> list = new ArrayList<>();
        for (int i: nums) {
            heap.insert(i);
            list.add(heap.getHeap().get(0));
        }
        return list;

    }
}
