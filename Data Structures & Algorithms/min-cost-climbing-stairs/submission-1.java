class Solution {
    private int f(int ind, int[] cost, int n, int[] dp){
        // base
        if(ind >= n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int one = f(ind + 1, cost, n, dp);
        int two = f(ind + 2, cost, n, dp);
        return dp[ind] = cost[ind] + Math.min(one, two);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 2];
        // for(int i = 0; i < n; i++) dp[i] = -1;
        // dp[n] = 0;
        // dp[n + 1] = 0;
        int prev1 = 0, prev2 = 0, curr;
        for(int ind = n - 1; ind >=0; ind--){
            // int one = dp[ind + 1];
            // int two = dp[ind + 2];
            curr = cost[ind] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = curr;
        }
        return Math.min(prev1, prev2);
    }
}