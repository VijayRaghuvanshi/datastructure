package com.leetcode.easy;

import java.util.Arrays;

public class IndexOfFirstOccurance {

    public static void main(String[] args) {
        System.out.println( strStr("butsadbut","sad"));
    }


    public static int strStr(String haystack, String needle) {
        int index  = -1;
        if(( haystack == null && needle == null) || haystack.length()< needle.length()){
            return -1;
        }
       int needleLength =  needle.length();

        for (int i = 0; i< haystack.length()-(needleLength-1); i++){
            String str = haystack.substring(i, (needleLength+i));
            System.out.println(str);
            if(needle.equals(str)){
                index = i;
                break;
            }
        }
        return index;
    }

}
