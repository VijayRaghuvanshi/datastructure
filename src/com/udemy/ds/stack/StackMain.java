package com.udemy.ds.stack;

public class StackMain {
/*    public static void main(String[] args) {
        Stack myStack = new Stack(2);
        myStack.push(1);

        // (2) Items - Returns 1 Node
        System.out.println(myStack.pop().value);
        // (1) Item - Returns 2 Node
        System.out.println(myStack.pop().value);
        // (0) Items - Returns null
        System.out.println(myStack.pop());


        *//*
            EXPECTED OUTPUT:
            ----------------
            1
            2
            null

        *//*

    }*/


    // WRITE THE REVERSESTRING METHOD HERE //
    //                                     //
    //                                     //
    //                                     //
    //                                     //
    /////////////////////////////////////////

    static String reverseString(String str ){
        if (str==null|| str.length()==1){
            return str;
        }
        Stack<Character> stack = new Stack<>();
        for (Character a: str.toCharArray()) {
            stack.push(a);
        }

        String reverseString = "";
        while (!stack.isEmpty()){
            reverseString+=stack.pop();
        }
        return reverseString;
    }

    static boolean isBalancedParentheses(String parenthesisStr){
        Stack<Character> stack = new Stack<>();
        if (parenthesisStr==null|| parenthesisStr.length()==1){
            return false;
        }
        for (Character a: parenthesisStr.toCharArray()) {
            if (a.equals('(')) {
                stack.push(a);
            }
            if (a.equals(')')){
               if(stack.pop()==null){
                   return false;
               }
            }
        }
        return stack.isEmpty();
    }



    public static void main(String[] args) {

        String myString = "hello";
        String reversedString = reverseString(myString);
        System.out.println(reversedString);

        /*
            EXPECTED OUTPUT:
            ----------------
            olleh
        */



    }
    public static void  sortStack(Stack<Integer> stack){
        if (stack==null || stack.isEmpty() || stack.size()==1){
            return;
        }
        Stack<Integer> sortedStack = new Stack();
        while (!stack.isEmpty()){
            Integer toBePlaced = stack.pop();
            while ( sortedStack.peek() != null &&  sortedStack.peek() > toBePlaced)
            {
                stack.push(sortedStack.pop());
            }
            sortedStack.push(toBePlaced);
        }
        while (!sortedStack.isEmpty()){
            stack.push(sortedStack.pop());
        }

    }
}
