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
        int prev3 = 0, prev2 = 1, prev1 = 1, curr;
        for(int ind = 3; ind <=n;ind++){
            curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}