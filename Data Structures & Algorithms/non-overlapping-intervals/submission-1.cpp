class Solution {
public:
    int eraseOverlapIntervals(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](const vector<int> &a, const vector<int> &b){
            if(a[1]!=b[1]) return a[1] < b[1];
            else return a[0] < b[0];
        });
        vector<int> prev = {INT_MIN, INT_MIN};
        int count = 0;
        for(const vector<int> &interval: intervals){
            if(interval[0] < prev[1]) {
                count++;
                continue;
            }
            prev[0] = interval[0];
            prev[1] = interval[1];
        }
        return count;
    }
};
