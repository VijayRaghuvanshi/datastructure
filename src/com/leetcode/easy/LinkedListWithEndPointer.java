package com.leetcode.easy;

import java.util.AbstractList;

public class LinkedListWithEndPointer  {

   private Node tail;
    int size;

    public LinkedListWithEndPointer(){

    }

    private void add(int data)
    {
        Node node = new Node(data);
        if (tail == null ){
            tail = node;
        }
        else{
            tail.next=node;
            tail = node;
        }
    }

    public int get(int pos){

        //returns data from end
        Node node = tail;
        int index =0;
        int retrunData=-1;
        while( node != null ){
            if(index == pos){
                retrunData = node.data();
                break;
            }
            else{
                node = node.next();
            }
        }
        return retrunData;

    }



    private static class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }

        public int data(){
            return this.data;
        }
        public Node next(){
            return this.next;
        }
    }
}
