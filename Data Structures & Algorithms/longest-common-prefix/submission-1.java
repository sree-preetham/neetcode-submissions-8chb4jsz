class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
		String last = strs[strs.length-1];
		String lcp = "";
        int i = 0, j = 0;
        while(i < first.length() && j < last.length() && first.charAt(i) == last.charAt(j)){
            lcp+=first.charAt(i);
            i++;j++;
        }
        return lcp;
    }
}