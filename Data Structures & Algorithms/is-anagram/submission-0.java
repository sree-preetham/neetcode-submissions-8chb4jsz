class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> mp1 = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = mp1.getOrDefault(c, 0);
            mp1.put(c,  count + 1);
            char ct = t.charAt(i);
            count = mp1.getOrDefault(ct, 0);
            mp1.put(ct, count - 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!mp1.get(c).equals(0)) return false;
        }
        return true;
    }
}
