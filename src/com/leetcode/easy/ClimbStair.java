package com.leetcode.easy;

import java.util.HashMap;

public class ClimbStair {
    public static void main(String[] args) {

    }
    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = -1;
        }
        return countWays(n, dp);
    }

    static int countWays(int n, int dp[])
    {
        if (n <= 1)
            return dp[n] = 1;

        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = countWays(n - 1, dp) + countWays(n - 2, dp);
        return dp[n];
    }
}
