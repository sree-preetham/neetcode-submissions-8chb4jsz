class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(const auto &ch:s){
            switch (ch){
                case ')':
                    if(st.empty() || st.top()!='(') {
                        return false;
                    }
                    st.pop();
                    break;
                case '}':
                    if(st.empty() || st.top()!='{') return false;
                    st.pop();
                    break;
                case ']':
                    if(st.empty() || st.top()!='[') return false;
                    st.pop();
                    break;
                default: 
                    st.push(ch);
            }
        }
        return st.empty();
    }
};