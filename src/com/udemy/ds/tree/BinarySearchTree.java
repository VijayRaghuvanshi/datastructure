package com.udemy.ds.tree;

public class BinarySearchTree {
    private Node root;

    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insert(int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        boolean flag = false;
        while (temp != null){
            if (temp.value == newNode.value){
                flag = false;
                break;
            }
            if (newNode.value < temp.value){
                if (temp.left == null){
                    temp.left = newNode;
                    flag = true;
                    break;
                }else{
                    temp = temp.left;
                }
            }else {
                if (temp.right==null){
                    temp.right = newNode;
                    flag = true;
                    break;
                }else {
                    temp = temp.right;
                }
            }
        }
        return flag;
    }
    public boolean contains(int value){
        if (root==null){
            return false;
        }
        Node temp = root;

        while (temp!=null){
            if (temp.value ==value){
                return true;
            }else if (value < temp.value ){
                    temp = temp.left;
            }
            else {
                temp = temp.right;
            }
        }
        return false;
    }
}
