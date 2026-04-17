class Solution {
    public int subarraySum(int[] nums, int k) {
        final int n = nums.length;
        int[] prefix = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0, 1);
        for(int i = 0; i < n; i++){
            int num = nums[i];
            sum = sum + num;
            prefix[i] = sum;
            int targetDifference = sum - k;
            count = count + map.getOrDefault(targetDifference, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}