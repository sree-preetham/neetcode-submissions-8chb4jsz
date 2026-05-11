class Solution {
    private int f(int ind, int rob_flag, int[] nums, int n, int[][] dp){
        if(ind >= n) return 0;
        if(dp[ind][rob_flag]!=-1) return dp[ind][rob_flag];
        int rob = 0;
        if(rob_flag == 0) rob = nums[ind] + f(ind + 1, 1, nums, n, dp);
        int not_rob = f(ind + 1, 0, nums, n, dp);
        return dp[ind][rob_flag] = Math.max(rob, not_rob);
    }
    private void reset(int[][] dp){
        // for(int[] row: dp) Arrays.fill(row, -1);
        for(int[] row: dp) Arrays.fill(row, 0);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        // int[][] dp = new int[n+1][2];
        int[] prev = new int[2];
        int[] curr = new int[2];
        // reset(dp);
        for(int ind = n - 2; ind>=1;ind--){
            for(int rob_flag = 0; rob_flag < 2; rob_flag++){
                int rob = 0;
                if(rob_flag == 0) rob = nums[ind] + prev[1];
                int not_rob = prev[0];
                curr[rob_flag] = Math.max(rob, not_rob);
            }
            prev[0] = curr[0];
            prev[1] = curr[1];
        }
        int rob_first = nums[0] + prev[1];
        // reset(dp);
        prev[0] = 0;
        prev[1] = 0;
        for(int ind = n - 1; ind>=1;ind--){
            for(int rob_flag = 0; rob_flag < 2; rob_flag++){
                int rob = 0;
                if(rob_flag == 0) rob = nums[ind] + prev[1];
                int not_rob = prev[0];
                curr[rob_flag] = Math.max(rob, not_rob);
            }
            prev[0] = curr[0];
            prev[1] = curr[1];
        }
        int not_rob_first = prev[0];
        return Math.max(rob_first, not_rob_first);
    }
}