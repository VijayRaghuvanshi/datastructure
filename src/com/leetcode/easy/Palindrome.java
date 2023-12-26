package com.leetcode.easy;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(1331));
        System.out.println(isPalindromeWithoutStringConversion(1331));
    }
    public static boolean isPalindrome(int x) {
        String numStr = Integer.toString(x);
        char[] charArr = numStr.toCharArray();
        boolean flag = true;
        for (int i = 0, j= charArr.length-1; i < j; i++,j--){
            if(charArr[i]==charArr[j] ){
                continue;
            }else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /**
     * Approach without converting to String
     * @param x
     * @return
     */
    public static boolean isPalindromeWithoutStringConversion(int x) {

        //return false if number is -ve
        if(x < 0 ){
            return false;
        }else if( x/10==0) { //return true if number is single digit.
            return true;
        }

        //divisor for getting first digit
        int divisor = 10;
        while(x/divisor >= 10)
        {
            divisor *=10;
        }
        int n = x;
        while (n > 0 && divisor !=0){
            int firstDigit = n/divisor;
            int lastDigit = n % 10;
            if(firstDigit != lastDigit)
            {
                return false;
            }
            n = (n%divisor)/10;
            // Reducing divisor by a factor
            // of 2 as 2 digits are dropped
            divisor = divisor/100;
        }
        return true;
    }
}
