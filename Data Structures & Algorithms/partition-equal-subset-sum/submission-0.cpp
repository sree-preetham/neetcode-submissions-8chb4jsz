class Solution {
public:
    bool f(int ind, int target, vector<int> &nums, vector<vector<int>> &dp){
        // base
        if(target==0) return true;
        else if(ind == nums.size()) return false;

        // if (mp[ind].find(target) != mp[ind].end()){
        //     return mp[ind][target];
        // }

        if(dp[ind][target]!=-1) return dp[ind][target];

        bool pick = false;
        if(nums[ind] <= target) pick = f(ind+1, target - nums[ind], nums,dp);

        bool not_pick = f(ind+1, target, nums,dp);

        return dp[ind][target] = pick || not_pick;
    }
    bool canPartition(vector<int>& nums) {
        int sum = accumulate(nums.begin(), nums.end(),0);
        if(sum % 2) return false;
        // unordered_map<int,unordered_map<int,bool>> mp;
        int n = nums.size();
        vector<int> prev_row(sum/2+1,1);
        for(int i = 1;i<=sum/2;i++) prev_row[i] = 0;

        for(int ind = n - 1;ind>=0;ind--){
            vector<int> curr_row(sum/2+1,-1);
            for(int target = 1; target <= sum/2; target++){
                bool pick = false;
                if(nums[ind] <= target) pick = prev_row[target-nums[ind]];
                bool not_pick = prev_row[target];
                curr_row[target] = pick || not_pick;
            }
            prev_row = curr_row;
        }

        return prev_row[sum/2];
    }
};