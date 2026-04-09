class Solution {
public:
    vector<int> prevSmallestElement(vector<int> & heights, const int n){
        stack<int> st;
        st.push(0);
        vector<int> ans(n,-1);
        for(int i = 1;i<n;i++){
            if(heights[i] <= heights[st.top()]){
                while(!st.empty() && heights[i] <= heights[st.top()]){
                    st.pop();
                }
                if(!st.empty()) {
                    cout<<st.top()<<endl;
                    ans[i] = st.top();
                }
                st.push(i);
            }
            else{
                ans[i] = st.top();
                st.push(i);
            }
        }
        return ans;
    }
    
    vector<int> nextSmallestElement(vector<int> & heights, const int n){
        stack<int> st;
        st.push(0);
        vector<int> ans(n,n);
        for(int i = 1;i<n;i++){
            if(heights[i] < heights[st.top()]){
                while(!st.empty() && heights[i] < heights[st.top()]){
                    ans[st.top()] = i;
                    st.pop();
                }
                st.push(i);
            }
            else{
                st.push(i);
            }
        }
        return ans;
    }
    int largestRectangleArea(vector<int>& heights) {
        const int n = heights.size();
        vector<int> prev_smallest = prevSmallestElement(heights,n);
        vector<int> next_smallest = nextSmallestElement(heights,n);
        int max_area = 0;
        for(int i = 0;i<n;i++){
            int curr_area = (next_smallest[i] - prev_smallest[i] - 1) * heights[i];
            max_area = max(max_area,curr_area);
        }
        return max_area;
    }
};