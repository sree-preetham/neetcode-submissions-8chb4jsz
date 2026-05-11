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
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) dp[i] = -1;
        return f(0, n, dp);
    }
}
