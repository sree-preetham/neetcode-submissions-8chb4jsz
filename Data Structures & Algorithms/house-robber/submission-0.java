class Solution {
    int solve(int[] nums, int ind, int n, int rob_flag, int[][] dp){
        // base condition
        if(ind == n) return 0;
        if(dp[ind][rob_flag]!=-1) return dp[ind][rob_flag];
        int rob = Integer.MIN_VALUE;
        if(rob_flag == 0) rob = nums[ind] + solve(nums, ind+1, n, 1, dp);
        int no_rob = solve(nums, ind+1, n, 0, dp);

        return dp[ind][rob_flag] = Math.max(rob, no_rob);
    }
    public int rob(int[] nums) {
        int answer;
        final int n = nums.length;
        if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0], nums[1]);
        // int rob_flag = 0;
        // int[][] dp = new int[n+1][2];
        int[] prev = new int[2];
        int[] curr = new int[2];
        for(int ind = n - 1; ind >=0; ind--){
            for(int rob_flag = 0; rob_flag < 2; rob_flag++){
                int rob = Integer.MIN_VALUE;
                if(rob_flag == 0) rob = nums[ind] + prev[1];
                int no_rob = prev[0];
                curr[rob_flag] = Math.max(rob, no_rob);
            }
            prev = curr.clone();
        }
        return curr[0];
    }
}