class Solution {
     public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2]; // is the memory assigned when I am doing this both in C++, JAVA ? 
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0;i < nums.length;i++){ // means that you're incorrectly calling length() as if it's a method, but length is a property (not a method) for arrays in Java.
            int pair = target - nums[i];
            if(mp.getOrDefault(pair,-1)!=-1){
                ans[0] = mp.getOrDefault(pair,-1);
                ans[1] = i;
                break;
            }
            mp.put(nums[i], i);
        }
        return ans;
    }
}
