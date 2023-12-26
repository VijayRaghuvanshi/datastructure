package com.udemy.ds.linkedlist;

import java.util.Arrays;

public class LinkedListMain {

    public static void main(String[] args) {
        //kth node
      /*  LinkedList myList = new LinkedList(1);
      myList.append(2);
        myList.append(3);
          myList.append(4);
        myList.append(5);
        myList.append(6);
       int val = myList.findMiddleNode();
        System.out.println(val);
        */
        //partitionlist
       /* LinkedList ll = new LinkedList(0);
        ll.append(5);
        ll.append(8);
        ll.append(10);
        ll.append(2);
        ll.append(1);
        // Print the list before partitioning
        System.out.println("LL before partitionList:");
        ll.printList(); // Output: 3 5 8 10 2 1
        ll.partitionList(5);
        ll.printList(); // Output: 3 2 1 5 8 10*/


        //remove duplicates
/*        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(1);
        myLinkedList.append(2);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.removeDuplicates();
        myLinkedList.printList();*/

        /*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            3
            4

        */


        // convert binary to decimal---------------
        // Convert 1011 to 11
        // ---------------
/*        LinkedList list1 = new LinkedList(1);
        list1.append(0);
        list1.append(1);
        list1.append(1);
        System.out.println("Convert 1011 to 11:");
        System.out.println("Input: 1 -> 0 -> 1 -> 1");
        System.out.println("Output: " + list1.binaryToDecimal());
        System.out.println("---------------");
        */

        //reverse sublist.
        // Create a linked list with values 1, 2, 3, 4, and 5
        LinkedList myLinkedList = new LinkedList(1);
        myLinkedList.append(2);
        myLinkedList.append(3);
        myLinkedList.append(4);
        myLinkedList.append(5);

        System.out.println("Original linked list: ");
        myLinkedList.printList();

        // Reverse a sublist within the linked list
       // myLinkedList.reverseBetweenNew(0, 4);
        //System.out.println("\nReversed sublist (1, 3): ");


        // Reverse a sublist of length 1 within the linked list
/*        myLinkedList.reverseBetweenNew(2, 2);
        System.out.println("\nReversed sublist of length 1 (2, 2): ");
        myLinkedList.printList();*/


        // Reverse an empty linked list
        LinkedList emptyList = new LinkedList(0);
        emptyList.makeEmpty();
        emptyList.reverseBetweenNew(0, 0);
        System.out.println("\nReversed empty linked list: ");
        emptyList.printList();

    }

}
