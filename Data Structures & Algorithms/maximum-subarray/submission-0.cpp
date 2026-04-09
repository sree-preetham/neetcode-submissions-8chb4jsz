class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxi = INT_MIN;
        int curr_sum = 0;
        for(int i = 0;i < nums.size();i++){
            curr_sum = max(nums[i], nums[i] + curr_sum);
            maxi = max(maxi, curr_sum);
        }
        return maxi;
    }
};