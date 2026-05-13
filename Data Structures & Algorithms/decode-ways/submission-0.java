class Solution {
    private int f(int ind, String s, Set<String> set, int[] dp){
        if(ind == s.length()) return 1;
        
        // pick 1 char
        if(dp[ind]!=-1) return dp[ind];

        int pick_one = f(ind+1, s, set, dp);
        int pick_two = 0;
        if(ind < s.length() - 1){
            String result = s.substring(ind, ind + 2);
            if(set.contains(result)) pick_two = f(ind+2, s, set, dp);
        }
        return dp[ind] = pick_one + pick_two;
    }
    public int numDecodings(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        for (int i = 1; i <= 26; i++) {
            set.add(String.valueOf(i));
        }
        dp[n] = 1;
        for(int ind = n - 1; ind >=0; ind--){
            if(s.charAt(ind) == '0') {
                dp[ind] = 0;
                continue;
            }
            int pick_one = dp[ind+1];
            int pick_two = 0;
            if(ind < n- 1){
                String result = s.substring(ind, ind + 2);
                if(set.contains(result)) pick_two = dp[ind+2];
            }
            dp[ind] = pick_one + pick_two;
        }
        return dp[0];
    }
}