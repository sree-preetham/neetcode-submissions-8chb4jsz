class Solution {
public:
    bool canCatchUp(int currentPosition, unordered_map<int,int> &mp, int target, int nextCarPosition){
        double t1, t2;
        t1 = (double)(target - currentPosition)/(double)mp[currentPosition];
        t2 = (double)(target - nextCarPosition)/(double)mp[nextCarPosition];
        if(t1 <= t2) return true;
        return false;
    }
    int carFleet(int target, vector<int>& position, vector<int>& speed) {
        // unordered_map<int,int> mp;
        vector<pair<int,int>> cars;
        for(int i = 0;i<position.size();i++){
            // mp[position[i]] = speed[i];
            cars.push_back({position[i],speed[i]});
        } 
        // sort(position.begin(), position.end());
        sort(cars.begin(), cars.end());
        int fleets = 1;
        // int nextCarPosition = position[position.size() - 1];
        int nextCarPosition = cars[cars.size() - 1].first;
        int nextCarSpeed = cars[cars.size() - 1].second;
        for(int i = cars.size() - 2; i >=0; i--){
            int currentPosition = cars[i].first;
            int currentSpeed = cars[i].second;
            double t1, t2;
            t1 = (double)(target - currentPosition)/(double)currentSpeed;
            t2 = (double)(target - nextCarPosition)/(double)nextCarSpeed;
            if(t1 > t2){
                nextCarPosition = currentPosition;
                nextCarSpeed = currentSpeed;
                fleets++;
            }
        }
        return fleets;
    }
};