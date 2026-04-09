class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         List<List<String>> ans = new ArrayList<>();
        HashMap<String,List<Integer>> mp = new HashMap<>();
        for(int i = 0; i<strs.length;i++){
            String word = strs[i];
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            if(!mp.containsKey(sortedWord)){
                mp.put(sortedWord, new ArrayList<>());
            }
            mp.get(sortedWord).add(i);
        }
        for(Map.Entry<String,List<Integer>> entry : mp.entrySet()){
            List<Integer> indices = entry.getValue();
            List<String> ds = new ArrayList<>();
            for(int ind : indices) {
                ds.add(strs[ind]);
            }
            ans.add(ds);
        }
        return ans;
    }
}
