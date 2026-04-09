class Solution {
public:
    int candy(vector<int>& ratings) {
        const int n = ratings.size();
        vector<int> arr(n,1);
        for(int i = 0;i<n;i++) if(i > 0 && ratings[i] > ratings[i-1]) arr[i] = arr[i-1]+1; 
        for(int j = n-1;j>=0;j--) if(j < n-1 && ratings[j] > ratings[j+1]) if(arr[j]<=arr[j+1]) arr[j] = arr[j+1] + 1;
        return accumulate(arr.begin(),arr.end(),0);
    }
};