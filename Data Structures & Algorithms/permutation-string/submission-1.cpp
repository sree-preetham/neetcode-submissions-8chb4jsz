class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        if(s1.length() > s2.length()) return false;
        vector<int> freqA(26,0);
        vector<int> freqB(26,0);
        for(const auto &it:s1) freqA[it-'a']++;
        const int m = s1.length();
        const int n = s2.length();
        int left = 0, right = m, j = 0;
        while(j < right){
            freqB[s2[j]-'a']++;
            j++;
        }
        for(int right = m; right <= n; right++){
            bool ans = true;
            for(int i = 0;i<26;i++){
                if(freqA[i]!=freqB[i]){
                    ans = false;
                    break;
                }
            }
            if(ans) return true;
            freqB[s2[left]-'a']--;
            left++;
            if(right < n) freqB[s2[right]-'a']++;
        }
        return false;
    }
};