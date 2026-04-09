class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(map.getOrDefault(nums[i], -1) != -1){
                ans[0] = map.getOrDefault(nums[i], -1);
                ans[1] = i;
                break;
            }
            int rem = target - nums[i];
            map.put(rem, i);
        }
        return ans;
    }
}
