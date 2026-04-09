class TimeMap {
public:
    unordered_map<string, vector<pair<int,string>>> mp;
    TimeMap() {
        
    }
    
    void set(string key, string value, int timestamp) {
        mp[key].push_back({timestamp, value});
    }
    
    string get(string key, int timestamp) {
        vector<pair<int,string>> values = mp[key];
        const int n = values.size();
        int low = 0;
        int high = n - 1;
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(values[mid].first <= timestamp){
                ans = mid;
                low = mid + 1;
            }
            else if(values[mid].first > timestamp) high = mid - 1;
        }
        if(ans == -1) return "";
        return values[ans].second;
    }
};
