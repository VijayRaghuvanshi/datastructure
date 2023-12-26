package com.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"abcx","abcy","lmnt90"}));
        System.out.println(longestCommonPrefix(new String[]{"abc"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length==0){
            return "";
        }
        if(strs.length ==1){
            return strs[0];
        }
        String prefix = strs[0];
        for (int i = 1; i<strs.length;i++){
            while (!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.equals("")){
                    return "";
                }
            }
        }
        return prefix;
    }
}
