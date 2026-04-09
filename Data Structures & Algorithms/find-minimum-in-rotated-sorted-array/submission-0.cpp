class Solution {
public:
    int findMin(vector<int>& nums) {
        const int n = nums.size();
        int low = 0;
        int high = n - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if((mid == 0 || nums[mid] < nums[mid-1]) && (mid == n-1 || nums[mid] < nums[mid+1])) {
                return nums[mid];
            }
            else if (nums[mid] < nums[n-1]) high = mid - 1;
            else low = mid + 1;
        }
        return nums[low];
    }
};