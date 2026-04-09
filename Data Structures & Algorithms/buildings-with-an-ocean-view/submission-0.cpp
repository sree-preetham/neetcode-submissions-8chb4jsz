class Solution {
public:
    vector<int> findBuildings(vector<int>& heights) {
        const int n = heights.size();
        vector<int> ans;
        int prev = -1;
        for(int i = n-1;i>=0;i--){
            if(heights[i] > prev){
                prev = heights[i];
                ans.push_back(i);
            }
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};