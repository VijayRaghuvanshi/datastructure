package com.udemy.ds.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    private Node head;
    private Node tail;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (head == null) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("\nLinked List:");
        if (head == null) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // WRITE FIND MIDDLE NODE METHOD HERE //
    //                                    //
    //                                    //
    //                                    //
    //                                    //
    ////////////////////////////////////////

    public int findMiddleNode(){

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next!=null )
        {
            fast = fast.next.next;
            slow = slow.next;

        }

        return slow.value;
    }


    public boolean hasLoop(){

        Node slow = head;
        Node fast = head;
        boolean loopFlag = false;
        while (fast != null && fast.next!=null )
        {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                loopFlag = true;
                break;
            }
        }
        return loopFlag;
    }

    public Node findKthFromEnd(int pos){
        Node slow = head;
        Node fast = head;

        for (int i=0;i<pos;i++){
            if (fast ==null){
                return null;
            }
            fast = fast.next;
        }
        while (fast !=null){
            fast =fast.next;
            slow=slow.next;
        }
        return slow;

    }
    public void partitionList(int x){

        if (head==null)
            return;

        Node lessListHead = null;
        Node lessListLast = null;
        Node greaterListHead = null;
        Node greaterListLast = null;


        while (head!=null){
            if (head.value<x){
                if (lessListHead == null){
                    lessListHead = head;
                    lessListLast = lessListHead;
                }else {
                     lessListLast.next = head;
                    lessListLast = lessListLast.next;
                }
            } else {
                if (greaterListHead == null){
                    greaterListHead = head;
                    greaterListLast = head;
                }else {
                    greaterListLast.next = head;
                    greaterListLast = greaterListLast.next;
                }
            }
            head = head.next;
        }
        if (lessListHead != null){
            lessListLast.next = greaterListHead;
            if (greaterListLast !=null){
                greaterListLast.next=null;
            }
           head = lessListHead;
        } else if (greaterListHead != null){
            greaterListLast.next = null;
            head = greaterListHead;

        }
    }

    public void removeDuplicates(){
        Node prev = null;
        Node temp = head;
        Set<Integer> set = new HashSet<>();
        while (temp !=null){
            if (set.add(temp.value)){
                prev = temp;
                temp = temp.next;
            }else{
                prev.next=temp.next;
                temp.next=null;
                temp = prev.next;
            }
        }
    }

    /**
     * dobling method from left to right.
     */
    public int binaryToDecimal(){
        Node temp = head;
        int result = 0;
        while (temp != null){
            result = (result*2)+temp.value;
            temp = temp.next;
        }
        return result;
    }

    public void reverseBetween(int m, int n){
        // First move the current pointer to the node from
        // where we have to reverse the linked list
        Node curr = head, prev = null;
        // prev points to the node before mth node
        int i;
        for (i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }
        // This pointer stores the pointer to the head of
        // the reversed linkedlist
        Node rtail = curr;
        // This pointer stores the pointer to the tail of
        // the reversed linkedlist
        Node rhead = null;
        // Now reverse the linked list from m to n nodes
        while (i <= n) {
            Node next = curr.next;
            curr.next = rhead;
            rhead = curr;
            curr = next;
            i++;
        }
        // if prev is not null it means that some of the
        // nodes exits before m ( or if m!=1)
        if (prev != null)
            prev.next = rhead;
        else
            head = rhead;
        // at this point curr will point to the next of nth
        // node where we will connect the tail of the
        // reversed linked list
        rtail.next = curr;

    }

    public void reverseBetweenNew(int m, int n){

        if(head == null || head.next==null){
            return;
        }
        Node dummyNode = new Node(head.value);
        dummyNode.next = head;

        Node leftpre = dummyNode;
        for (int i=0; i< m; i++){
            leftpre = leftpre.next;
        }
        Node currentNode = leftpre.next;
        Node sublistHead = leftpre.next;
        Node pre = leftpre;

        for (int i=0; i < (n-m)+1; i++){
             Node nextNode = currentNode.next;
             currentNode.next = pre;
             pre = currentNode;
             currentNode = nextNode;
        }
        leftpre.next = pre;
        sublistHead.next= currentNode;
        head = dummyNode.next;
    }

}

