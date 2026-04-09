class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int maxi = 0;
        for(int num : nums){
            if(mp.containsKey(num)) continue;
            int leftEdge = num;
            int rightEdge = num;

            int leftCount = 0;
            int rightCount = 0;
            if(mp.containsKey(num - 1)){
                leftCount = mp.get(num - 1);
                leftEdge = num - leftCount;
            }
            if(mp.containsKey(num + 1)){
                rightCount = mp.get(num + 1);
                rightEdge = num + rightCount;
            }
            
            mp.put(leftEdge, leftCount + rightCount + 1);
            mp.put(rightEdge, leftCount + rightCount + 1);
            mp.put(num, leftCount + rightCount + 1);
            maxi = Math.max(maxi, leftCount + rightCount + 1);
        }
        return maxi;
    }
}