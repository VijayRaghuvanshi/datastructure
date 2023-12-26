package com.udemy.ds.queue;

public class Queue {
    private Node  first;
    private Node last;

    private int length;

    public Queue(int value){
        Node node = new Node(value);
        this.first = node;
        this.last = node;
        this.length = 1;
    }

    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value  = value;
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);
        if (length==0){
            first = newNode;
            last= newNode;
        }
        else {
            last.next=newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue(){
        if (length==0){
            return null;
        }
        Node temp = first;
        if (length==1){
            last = null;
        }
        first = temp.next;
        temp.next = null;
        length--;
        return temp;
    }
}
