class Solution {
public:
    int solve(const vector<int>& nums, int n, int i, int j, vector<vector<int>> &dp){
        // base condition
        if(i == n) return 0;
        if(dp[i][j + 1]!=-1) return dp[i][j + 1];
        int take = 0;
        if(j == -1 || nums[i] > nums[j]){
            take = 1 + solve(nums, n, i + 1, i, dp);
        }
        int not_take = solve(nums, nums.size(), i + 1, j, dp);
        return dp[i][j + 1] = max(take, not_take);
    }
    int lengthOfLIS(vector<int>& nums) {
        const int n = nums.size();
        vector<vector<int>> dp(n, vector<int>(n + 1, -1));
        return solve(nums, n, 0, -1, dp);
    }
};