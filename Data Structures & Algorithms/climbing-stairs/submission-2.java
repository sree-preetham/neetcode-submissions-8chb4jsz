class Solution {
    /*
        1 2 3 4 5 6 .......n
    */
    private int f(int ind, int n, int[] dp){
        if(ind == n) return 1;
        if(dp[ind]!=-1) return dp[ind];
        int one = f(ind + 1, n, dp);
        int two = 0;
        if(n - ind >= 2) two = f(ind + 2, n, dp);
        return dp[ind] = one + two;
    }
    public int climbStairs(int n) {
        // int[] dp = new int[n + 1];
        // dp[n] = 1;
        int prev1 = 1, prev2 = 0;
        int curr;
        for(int ind = n - 1; ind>=0;ind--){
            // int one = prev1;
            // int two = 0;
            // if(n - ind >= 2) two = prev2;
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}