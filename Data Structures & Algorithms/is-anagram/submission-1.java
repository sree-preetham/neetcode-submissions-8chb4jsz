class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(Character ch: s.toCharArray()) map.put(ch, map.getOrDefault(ch, 0) + 1);
        for(Character ch: t.toCharArray()) {
            int frequency = map.getOrDefault(ch, 0);
            if(frequency == 0) return false;
            map.put(ch, frequency - 1);
        }
        return true;
    }
}
