package com.leetcode.easy;

import java.util.Arrays;

public class Sqrt {
    public static void main(String[] args) {
        System.out.println(  mySqrt(4));
        System.out.println(  mySqrt(8));
        System.out.println(  mySqrt(14));
    }

    public static int mySqrt(int x) {

        if(x < 2){
            return x;
        }
        int mid = 0;
        int start =1;
        int end = x;

        while (start <=end ){
              mid = (start+end)/2;
            if(mid*mid == x){
                return mid;
            } else if ( (mid * mid) > x) {
                end = mid-1;
            }else {
               start = start+1;
            }

        }

        return end;
    }
}
