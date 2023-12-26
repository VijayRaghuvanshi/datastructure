package com.udemy.ds;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value){
        Node node = new Node(value);
        head = node;
        tail = node;
        length++;
    }

    class Node {
        int value;
        Node next;
        Node prev;
        public Node(int value){
            this.value = value;
        }
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nDoubly Linked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value){
        Node node = new Node(value);
        if(length==0){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        length++;
    }
    public Node removeLast(){
        if (length==0)
            return null;
        Node deletedNode = null;
        deletedNode = tail;
        if (length==1){
            head = null;
            tail = null;
        }else {
            tail = tail.prev;
            tail.next = null;
        }
        length--;
        deletedNode.prev =null;
        return deletedNode;
    }

    public void prepend(int value){
        Node newNode  = new Node(value);
        if (length==0){
            head = newNode;
            tail = newNode;
        }else {
            newNode.next=head;
            head.prev=newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst(){
        if (length==0){
            return null;
        }
        Node deletedNode = head;
        if (length==1){
            head = null;
            tail = null;
        }else {
            head = head.next;
            head.prev = null;
        }
        length--;
        deletedNode.next=null;
        return deletedNode;
    }

    public Node get(int index){
        if (index < 0 || index >= length){
            return null;
        }
        boolean fromHead = index <= length/2?true:false;
        Node temp = null;
        if (fromHead){
            temp = head;
            for (int i =0; i < index; i++){
                temp = temp.next;
            }
        }else {
            temp = tail;
            for (int i=length-1; i >=index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node nodeToBeSet = get(index);
        boolean retFlag = false;
        if (nodeToBeSet!=null){
            nodeToBeSet.value = value;
            retFlag = true;
        }
        return retFlag;
    }

    public boolean insert(int index, int value){
        boolean retFlag = false;
        if (index < 0 || index >length ){
            return retFlag;
        }else if (index==0){
            prepend(value);
            retFlag = true;
        } else if (index==length){
            append(value);
            retFlag = true;
        }else {
            Node beforeNode = get(index-1);
            Node afterNode = beforeNode.next;
            Node newNode = new Node(value);
            newNode.next = afterNode;
            newNode.prev = beforeNode;
            beforeNode.next = newNode;
            afterNode.prev = newNode;
            retFlag = true;
            length++;
        }
        return retFlag;
    }

    public Node remove(int index ){
        if (index < 0 || index >= length){
            return null;
        }
        if (index==0){
            return removeFirst();
        }
        if (index == length-1){
            return removeLast();
        }
        Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;
    }

    public void swapFirstLast(){
        if (length < 2){
            return;
        }
        int firstVal = head.value;
        head.value=tail.value;
        tail.value=firstVal;
        return;
    }

    public void reverse(){
        if (length < 2) {
            return;
        }
        Node temp = head;
        Node tempNext = null;
        while (temp != null)
        {
            tempNext = temp.next;
            temp.next=temp.prev;
            temp.prev=tempNext;
            temp = tempNext;
        }
        Node tailTemp = tail;
        tail=head;
        head=tailTemp;
    }

    public boolean isPalindrome(){

        if (length < 2){
            return true;
        }
        Node first = head;
        Node last = tail;
        for (int i=0,j=length-1; i < j; i++, j--){
            if (first.value != last.value){
                return false;
            }
            first = first.next;
            last = last.prev;
        }
        return true;
    }

    public void swapPairs(){

        if (length < 2){
            return;
        }
        Node first = head;
        Node sec = head.next;
        head = sec;
        Node firstPre = null;
        while (first!=null && sec != null){
            firstPre = first.prev;
            first.next = sec.next;
            first.prev = sec;

            sec.next = first;
            sec.prev =firstPre;

            if(firstPre!=null){
                firstPre.next = sec;
            }
            if (first.next != null)
            {
                first.next.prev = first;
                first = first.next;
                sec = first.next;
            }else {
                break;
            }
        }
    }



}

