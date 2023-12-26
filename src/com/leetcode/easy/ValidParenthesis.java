package com.leetcode.easy;

import java.util.*;

public class ValidParenthesis {

    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
        Map<String, String> parentheses = new HashMap<>();
        parentheses.put("(",")");
        parentheses.put("[","]");
        parentheses.put("{","}");
        Stack<String> stack = new Stack<>();
        String symbol = "";
        char[] parenthesesArr = s.toCharArray();
        for (char c:parenthesesArr) {
            if (parentheses.get(""+c) != null) {
                stack.push(Character.toString(c));

            }else{
                if (stack.empty()){
                    return false;
                }
                symbol = stack.pop();
                if (!parentheses.get(symbol).equals(Character.toString(c))){
                    return false;
                }
            }
        }
        if (!stack.empty()){
            return false;
        }
        return true;
    }
}
