package com.leetcode.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {
 /*       ListNode node3 = new ListNode(2, null);
        ListNode node2 = new ListNode(1, node3);
        ListNode node = new ListNode(1, node2);

*/

        ListNode node5 = new ListNode(3, null);
        ListNode node4 = new ListNode(3, node5);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node = new ListNode(1, node2);

        ListNode resultNode = deleteDuplicates(node4);
        while (resultNode != null){
            System.out.println(resultNode.val);
            resultNode = resultNode.next;
        }

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode tempNode = head;
        while (tempNode != null){
            if (tempNode.next != null) {
                ListNode duplicateNode = tempNode.next;
                while (tempNode.next != null && duplicateNode != null && tempNode.val == duplicateNode.val) {
                    duplicateNode = duplicateNode.next;
                }
                tempNode.next=duplicateNode;
            }
            tempNode = tempNode.next;
        }
        return head;
    }

}




   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
     ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

