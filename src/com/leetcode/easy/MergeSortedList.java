package com.leetcode.easy;

import java.util.List;
import java.util.ListIterator;

public class MergeSortedList {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }

        ListNode resultHead;
        ListNode temp;
        ListNode l1=list1;
        ListNode l2 = list2;
       if(l1.val < l2.val){
           resultHead = new ListNode(l1.val);
           temp = resultHead;
           l1=l1.next;
       }
        else{
            resultHead = new ListNode(l2.val);
            temp = resultHead;
            l2=l2.next;
        }
        while (l1 !=null && l2 !=null){
            if(l1.val < l2.val){
                temp.next = new ListNode(l1.val);
                l1=l1.next;
            }
            else{
                temp.next = new ListNode(l2.val);
                l2=l2.next;
            }
            temp = temp.next;
        }
        while (l1!=null){
            temp.next = new ListNode(l1.val);
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2!=null){
            temp.next = new ListNode(l2.val);
            l2 = l2.next;
            temp = temp.next;
        }
        return resultHead;
    }

    /*
     *
     * Definition for singly-linked list.
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
