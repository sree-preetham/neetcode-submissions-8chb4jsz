class Solution {
public:
    void generate(int ind, vector<string> &ans, string &ds, stack<char> &st, int n){
        // base
        if(ind == n){
            if(st.empty()) ans.push_back(ds);
            return;
        }
        st.push('(');
        ds.push_back('(');
        generate(ind+1, ans, ds, st, n);
        st.pop();
        ds.pop_back();

        if(!st.empty()){
            st.pop();
            ds.push_back(')');
            generate(ind+1, ans, ds, st, n);
            st.push('(');
            ds.pop_back();
        }
        return;
    }
    vector<string> generateParenthesis(int n) {
        vector<string> ans;
        string ds;
        stack<char> st;
        n = 2 * n;
        cout<<n<<endl;
        generate(0,ans,ds,st,n);
        return ans;
    }
};