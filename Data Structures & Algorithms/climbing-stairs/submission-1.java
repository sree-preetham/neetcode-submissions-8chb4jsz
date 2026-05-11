class Solution {
    private int f(int ind, int n, int[] dp){
        if(ind == n) return 1;
        if(dp[ind]!=-1) return dp[ind];
        int one = f(ind + 1, n, dp);
        int two = 0;
        if(n - ind >= 2) two = f(ind + 2, n, dp);
        return dp[ind] = one + two;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int ind = n - 1; ind>=0;ind--){
            int one = dp[ind + 1];
            int two = 0;
            if(n - ind >= 2) two = dp[ind + 2];
            dp[ind] = one + two;
        }
        return dp[0];
    }
}