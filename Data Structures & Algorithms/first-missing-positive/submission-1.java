class Solution {
    public int firstMissingPositive(int[] nums) {
        // Arrays.sort(nums);
        int missing = 1;
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num < 1) continue;
            map.put(num, true);
            // if(num < 1 || (i > 0 && nums[i] == nums[i-1])) continue;
            // if(num != missing) return missing;
            // missing++;
        }
        while(map.getOrDefault(missing, false)) missing++;
        return missing;
    }
}