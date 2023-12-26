package com.leetcode.easy;

import java.util.Arrays;

public class LengthOfLastWord {

    public static void main(String[] args) {

        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("a"));

    }
    public static int lengthOfLastWord(String s) {

        int lastWordLength = -1;
        if( s== null && s.trim().equals("")){
            return lastWordLength;
        }else if (s.trim().indexOf(' ') < 0){
            return  s.trim().length();
        }

        s = s.trim();
        System.out.println("last space index"+s.substring(s.lastIndexOf(' ')));

        lastWordLength = s.substring(s.lastIndexOf(' ')+1, s.length()).length();
        return lastWordLength;
    }
}
