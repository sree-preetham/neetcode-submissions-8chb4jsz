class Solution {
public:
    bool check(vector<int>&piles, int n, int h){
        int time = 0;
        for(const auto &pile:piles){
            // cout<<"curr is "<<curr<<" ceil is "<<ceil(curr)<<endl;
            time = time + (pile + n - 1)/n;
        }
        // cout<<"time taken for "<<n<<" is "<<time<<endl; 
        return time <= h;
    }
    int minEatingSpeed(vector<int>& piles, int h) {
        int maxi = *max_element(piles.begin(), piles.end());
        int low = 1;
        int high = maxi;
        while(low < high){
            int mid = low + (high-low)/2;
            // cout<<"low is "<<low<<" high is "<<high<<" mid is "<<mid<<endl;
            if(check(piles, mid, h)) high = mid;
            else low = mid + 1;
        }
        return low;
    }
};