package com.leetcode.easy;

import java.util.Arrays;

public class BinaryAddition {
    public static void main(String[] args) {

       // System.out.println(addBinary("11", "1"));
        //System.out.println(addBinary("1010", "1011"));
        System.out.println(addBinary("110010", "100"));
    }

    public static String addBinary(String a ,String b) {

        int lengthA = a.length();
        int lengthB = b.length();
        String biggerStr = lengthA > lengthB ? a : b;
        String smallStr = lengthA > lengthB ? b : a;
        char carry = '0';
        String resultStr = "";
        for (int i = biggerStr.length() - 1, j = smallStr.length() - 1; i >= 0; i--, j--) {
            char c = biggerStr.charAt(i);
            char c2 = j >= 0 ? smallStr.charAt(j) : '0';
            if (c == c2 && c == '0' && carry == '0') {
                resultStr = "0" + resultStr;
            } else if (c == c2 && c == '0' && carry == '1') {
                resultStr = "1" + resultStr;
                carry = '0';
            } else if (c == c2 && c == '1' && carry == '0') {
                resultStr = "0" + resultStr;
                carry = '1';
            } else if (c == c2 && c == '1' && carry == '1') {
                resultStr = "1" + resultStr;
                carry = '1';
            } else if (c != c2 && carry=='0') {
                resultStr = "1" + resultStr;
            } else if (c !=c2 && carry=='1') {
                resultStr = "0" + resultStr;
                carry='1';
            }

        }
        if (carry=='1')
            resultStr = "1" + resultStr;
        return  resultStr;
    }
    /*
     using java api. it has issue of overflowing. String could go beyond Integer limit.
     */
    public static String addBinaryJavaApi(String a, String b) {

        int first = Integer.parseInt(a, 2);
        int sec = Integer.parseInt(b, 2);
        int result =  first+sec;
        return Integer.toBinaryString(result);

    }

}
