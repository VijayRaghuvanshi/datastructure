
package com.udemy.ds;


public class LinkedList {

    // CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
    //                                                          //
    //                                                          //
    //                                                          //
    //                                                          //
    //////////////////////////////////////////////////////////////

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value){
        Node node = new Node(value);
        this.head = node;
        this.tail = node;
        this.length++;
    }
    class Node {
        private int value;
        private Node next;

        Node(int value){
            this.value =value;
            this.next = null;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void getHead() {
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.value);
        }
    }

    public void getTail() {
        if (head == null) {
            System.out.println("Tail: null");
        } else {
            System.out.println("Tail: " + tail.value);
        }
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value){
        Node node = new Node(value);
        if (head ==null ){
            head = node;
            tail = node;
        }
        if(tail !=null){
            tail.next=node;
            tail = tail.next;
        }
        length++;
    }

    public Node removeLast(){

        if(length == 0){
            return null;
        }

        Node temp =head;
        Node pre = head;
        while (temp !=null){
            pre =temp;
            temp =temp.next;
        }
        tail = pre;
        tail.next=null;
        length--;
        if (length==0){
            head=null;
            tail=null;
        }
        return temp;
    }

    public void prepend(int i){
        Node node = new Node(i);
        if(length==0){
            head=node;
            tail = node;
        }else {
            node.next = head;
            head = node;
        }
        length++;
    }

    public Node removeFirst(){

        if (length==0){
            return null;
        }
        head = head.next;
        Node returnNode = head;
        returnNode.next=null;
        length--;
        if (length==0){
            tail = null;
        }
        return returnNode;
    }

    public Node get(int index){

        if(index > length && index < 0){
            return null;
        }
        Node temp = head;
        for (int i=0;i<index;i++) {
            temp = temp.next;
        }
        temp.next=null;
        return temp;
    }

    public boolean set(int index, int value){
        Node temp =  get(index);
        boolean flag = false;
        if (temp!= null){
            temp.value = value;
            flag=true;
        }
        return flag;
    }

    public boolean insert(int index, int value){
        if (index < 0 || index > length){
            return false;
        }
        if (index==0){
            prepend(value);
            return true;
        }
        if (index==length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index-1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if (index == 0){
            return  removeFirst();
        }
        if (index==(length-1)){
            return removeLast();
        }
        Node pre = get(index-1);
        Node temp = pre.next;
        pre.next = temp.next;
        temp.next=null;
        length--;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node before = null;
        Node after = null;
        for(int i=0; i<length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp =after;
        }

    }


}
