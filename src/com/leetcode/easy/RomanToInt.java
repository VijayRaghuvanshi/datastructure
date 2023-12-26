package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("LVIII"));
    }

    public static int romanToInt(String s)
    {
        int result = 0;
        Map<String, Integer> romanMap = new HashMap<>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        char[] inputCharArr = s.toCharArray();
        int charToIntVal = -1;
        int prevVal = 0;
        for (char c: inputCharArr) {
            charToIntVal = romanMap.get(""+c);
            if(prevVal != 0 && prevVal < charToIntVal){
                result += (charToIntVal-(2*prevVal));
            }else {
                result += charToIntVal;
            }
            prevVal = charToIntVal;
        }
        return result;
    }
}
