package com.udemy.ds.treerecursive;

public class BinarySearchTree {
    private Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        private Node(int value) {
            this.value = value;
        }
    }

    public Node getRoot() {
        return root;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;
        Node temp = root;
        while (temp != null) {
            if (value < temp.value) {
                temp = temp.left;
            } else if (value > temp.value) {
                temp = temp.right;
            } else {
                return true;
            }
        }
        return false;
    }


    private boolean rContains(Node currentNode, int value) {
        if (currentNode == null) return false;

        if (currentNode.value == value) return true;

        if (value < currentNode.value) {
            return rContains(currentNode.left, value);
        } else {
            return rContains(currentNode.right, value);
        }
    }
    public boolean rContains(int value) { return rContains(root, value); }


    // WRITE THE RECURSIVE INSERT METHOD HERE //
    //                                        //
    //                                        //
    //                                        //
    //                                        //
    ////////////////////////////////////////////

    private Node rInsert(Node currentNode, int value){
        if (currentNode == null){
            return new Node(value);
        }
        else if (value < currentNode.value){
            currentNode.left = rInsert(currentNode.left,value);
        } else if (value > currentNode.value && currentNode.right!=null) {
            currentNode.right = rInsert(currentNode.right,value);
        }
        return currentNode;
    }

    public void rInsert(int value) {
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    public Integer minValue(Node node){
        if (node==null){
            return null;
        }
        while (node.left != null){
            node = node.left;
        }
        return node.value;
    }
    private Node deleteNode(Node currentNode, int value){
            if (currentNode==null){
                return null;
            }
            if (value < currentNode.value){
                 currentNode.left= deleteNode(currentNode.left, value);
            } else if (value > currentNode.value) {
                 currentNode.right = deleteNode(currentNode.right,value);
            }else{
                if (currentNode.left==null && currentNode.right==null){
                    return null;
                } else if (currentNode.left!=null && currentNode.right==null) {
                     currentNode = currentNode.left;
                }else if (currentNode.left==null && currentNode.right !=null){
                    currentNode = currentNode.right;
                }else {
                    int minValue = minValue(currentNode.right);
                    currentNode.value = minValue;
                    currentNode.right = deleteNode(currentNode.right,minValue);
                }
            }
            return currentNode;
    }


    public void deleteNode(int value){
        root = deleteNode(root, value);
    }
}
