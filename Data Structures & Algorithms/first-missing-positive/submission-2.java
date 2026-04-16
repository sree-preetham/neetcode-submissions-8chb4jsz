class Solution {
    public int firstMissingPositive(int[] nums) {
        // Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i < n; i++) if(nums[i] < 1 || nums[i] > n) nums[i] = n + 1;
        for(int i = 0; i < n; i++){
            int num = Math.abs(nums[i]);
            if(num > n || nums[num - 1] < 0) continue;
            // System.out.println(num + " " + nums[num-1]);
            nums[num - 1] = -1 * nums[num - 1];
        }
        for(int i = 0; i < n;i++){
            if(nums[i] > 0) {
                // System.out.println(i + " " + nums[i]);
                return i + 1;
            }
        }
        return n + 1;
    }
}