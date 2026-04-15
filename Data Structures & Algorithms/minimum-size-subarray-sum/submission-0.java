class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right, n = nums.length, count = 0, sum = 0;
        int mini = n + 1;
        for(right = 0; right < n; right++){
            sum = sum + nums[right];
            count++;
            while(sum >= target && left <= right){
                mini = Math.min(count, mini);
                sum = sum - nums[left];
                count--;
                left++;
            }
        }
        return mini > n ? 0: mini;
    }
}