package com.leetcode.easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IfConverseList {
    //assuming l2 list always smaller than l1

    public static void main(String arg[]){
        List<Integer> l1 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        List<Integer> l2 = new LinkedList<>();
        l2.add(4);
        l2.add(5);
        l2.add(6);

        int l1Size = l1.size();
        int l2Size = l2.size();
        int startPosL1  = l1Size - l2Size;
        int startPosL2 = 0;
        boolean flag = true;
        for (int i = 0; i< l2Size; i++){
            if(l2.get(i).equals(l1.get(startPosL1))){
                startPosL1++;
                continue;
            }
            else{
                flag = false;
                break;
            }
        }
       System.out.println("Does lists conversed: "+flag);
    }
}
