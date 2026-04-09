class Solution {
public:
    bool f(int i, int j, string &s, int k){
        if(i>=j) return true;
        if(s[i]==s[j]) return f(i+1,j-1,s,k);
        else if(k) return f(i+1,j,s,k-1) || f(i,j-1,s,k-1);
        return false;
    }
    bool validPalindrome(string s) {
        int n = s.length();
        return f(0, n-1, s, 1);
    }
};