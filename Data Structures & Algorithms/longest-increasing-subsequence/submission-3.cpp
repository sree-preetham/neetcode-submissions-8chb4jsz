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
        // vector<int> prev(n + 1, 0);
        // vector<int> curr(n + 1, 0);
        // // for(int j = -1; j < n; j++) dp[n][j] = 0;
        // for(int i = n - 1; i >=0; i--){
        //     for(int j = -1; j < n; j++){
        //         int take = 0;
        //         if(j == -1 || nums[i] > nums[j]){
        //             take = 1 + prev[i+1];
        //         }
        //         int not_take = prev[j+1];
        //         curr[j + 1] = max(take, not_take);
        //     }
        //     prev = curr;
        // }
        // // return solve(nums, n, 0, -1, dp);
        // return prev[0];
        vector<int> lis;
        for(const int &num: nums){
            int index = lower_bound(lis.begin(), lis.end(), num) - lis.begin();
            if(index == lis.size()) lis.push_back(num);
            else lis[index] = num;
        }
        return lis.size();
    }
};