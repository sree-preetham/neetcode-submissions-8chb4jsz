class Solution {
    private boolean f(int i, int j, String s, Set<String> set, int n, int[][] dp){
        // base
        if(i == n) return true;
        else if(j==n) return set.contains(s.substring(i, j));

        if(dp[i][j]!=-1) return dp[i][j] == 1;

        String sub = s.substring(i, j+1);
        boolean partition = false;
        if(set.contains(sub)) partition = f(j+1, j+1, s, set, n, dp);
        boolean not_partition = f(i, j + 1, s, set, n, dp);
        boolean ans = partition || not_partition;
        if(ans) dp[i][j] = 1;
        else dp[i][j] = 0;
        return ans;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String word: wordDict) set.add(word);
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] row: dp) Arrays.fill(row, -1);
        return f(0, 0, s, set, n, dp);
    }
}