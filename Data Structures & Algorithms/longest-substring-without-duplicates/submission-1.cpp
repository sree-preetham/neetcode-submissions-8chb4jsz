class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        if(s.length()==0) return 0;
        unordered_map<char, int> freq;
        int left = 0;
        int ans = 1;
        freq[s[0]] = 1;
        for(int right = 1; right < s.length();){
            while(right < s.length() && freq[s[right]] == 0){
                freq[s[right]]++;
                right++;
            }
            ans = max(ans, right - left);
            freq[s[left]]--;
            left = left + 1;
        }
        return ans;
    }
};