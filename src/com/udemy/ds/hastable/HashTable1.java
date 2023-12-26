package com.udemy.ds.hastable;

import java.util.ArrayList;
import java.util.List;

public class HashTable1 {
    private int size;
    private Node[] dataMap;

    public HashTable1(){
        this.size = 7;
        dataMap = new Node[7];
    }
    public HashTable1(int size){
        this.size = size;
        dataMap = new Node[size];
    }
    class Node{
        private String key;
        private int value;
        private Node next;
        Node(String key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public void set(String key, int value){
        int hash = hash( key);
        Node newNode = new Node(key, value);
        Node node = dataMap[hash];
        if (node == null){
            dataMap[hash] = newNode;
        }else{
            while(node.next != null){
                if (node.key.equals(key)){
                    break;
                }else{
                    node = node.next;
                }
            }
            if (node.key.equals(key)){
                node.value = value;
            }else {
                node.next = newNode;
            }
        }
    }
    public int get(String key){
        int hash = hash( key);
        Node node = dataMap[hash];
        if (node == null){
            return 0;
        }else{
            while(node != null){
                if (node.key.equals(key)){
                    return node.value;
                }
                node = node.next;
            }
           return 0;
        }
    }
    public List<String> keys(){
        List<String> keys = new ArrayList<>();
        for (Node node : dataMap) {
             while(node != null){
                 keys.add(node.key);
                 node = node.next;
             }
        }
        return keys;
    }


    private int hash(String key){
        int hash  = 0;
        char[] keyChars = key.toCharArray();
        for (char c: keyChars ) {
            int asciivalue = c;
            hash= (hash+asciivalue*23) % dataMap.length;
        }
        return hash;
    }

}
