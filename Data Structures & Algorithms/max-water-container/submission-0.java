class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxi = 0;
        for(int i = 0, j = n-1; i < j;){
            int currArea = Math.min(height[i], height[j]) * (j-i);
            maxi = Math.max(maxi, currArea);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxi;
    }
}