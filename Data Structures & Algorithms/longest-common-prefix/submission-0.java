class Solution {
    public String longestCommonPrefix(String[] strs) {
        String lcp = strs[0];
        String newLcp = "";
        for(String current: strs){
            int i = 0, j = 0;
            final int m = lcp.length();
            final int n = current.length();
            while(i < m && j < n && lcp.charAt(i) == current.charAt(j)){
                newLcp += lcp.charAt(i);
                i++;
                j++;
            }
            lcp = newLcp;
            if(lcp.length() == 0) return "";
            newLcp = "";
        }
        return lcp;
    }
}