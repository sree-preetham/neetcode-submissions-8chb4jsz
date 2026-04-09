class MinStack {
private:
    int mini;
    vector<pair<int,int>> arr;
public:
    MinStack() {
        mini = INT_MAX;
    }
    
    void push(int val) {
        mini = min(mini,val);
        arr.push_back({val, mini});
    }
    
    void pop() {
        arr.pop_back();
        if(arr.size() == 0) mini = INT_MAX;
        else mini = arr[arr.size()-1].second;
    }
    
    int top() {
        return arr[arr.size()-1].first;
    }
    
    int getMin() {
        return mini;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */