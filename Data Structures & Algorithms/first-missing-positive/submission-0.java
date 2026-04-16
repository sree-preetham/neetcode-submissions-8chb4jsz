class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int missing = 1;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num < 1 || (i > 0 && nums[i] == nums[i-1])) continue;
            if(num != missing) return missing;
            missing++;
        }
        return missing;
    }
}