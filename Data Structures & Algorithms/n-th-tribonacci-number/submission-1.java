class Solution {
    private int f(int n, int[] dp){
        if(n==0) return 0;
        else if(n==1 || n==2) return 1;
        if(dp[n]!=-1) return dp[n];
        return dp[n] = f(n-1, dp) + f(n-2, dp) + f(n-3, dp);
    }
    public int tribonacci(int n) {
        if(n==0) return 0;
        else if(n==1 || n==2) return 1;
        int[] dp = new int[n+1];
        // for(int i = 0; i < n + 1;i++) dp[i] = -1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int ind = 3; ind <=n;ind++){
            dp[ind] = dp[ind-1] + dp[ind-2] + dp[ind-3];
        }
        return dp[n];
    }
}