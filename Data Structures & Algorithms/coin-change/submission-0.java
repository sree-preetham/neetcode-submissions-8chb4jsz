class Solution {
    private int f(int ind, int[] coins, int amount, int n, int[][] dp){
        if(amount == 0) return 0;
        else if(ind == n) return 1000000000;
        if(dp[ind][amount]!=-1) return dp[ind][amount];
        int pick = 1000000000;
        if(coins[ind] <= amount) pick = 1 + f(ind, coins, amount - coins[ind], n, dp);
        int not_pick = f(ind+1, coins, amount, n, dp);
        return dp[ind][amount] = Math.min(pick, not_pick);
    }
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] row: dp) Arrays.fill(row, -1);
        int ans = f(0, coins, amount, n, dp);
        return ans >= 1000000000 ? -1 : ans;
    }
}