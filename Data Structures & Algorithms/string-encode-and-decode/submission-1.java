class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        String ans = "";
        for(String word : strs){
           encoded.append(word.length()).append("_").append(word);
        }
        return encoded.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> ans = new ArrayList<>();
        char[] charArray = s.toCharArray();
        System.out.println(s);
        for(int ind = 0;ind<charArray.length;){
            List<Character> chars = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            while(charArray[ind]!='_'){
                sb.append(charArray[ind]);
                ind++;
            }
            int wordLength = Integer.valueOf(sb.toString());
            ind++;
            StringBuilder ds = new StringBuilder();
            int i;
            for(i = ind; i < ind + wordLength; i++){
                ds.append(charArray[i]);
            }
            ans.add(ds.toString());
            ind = i;
        }
        return ans;
    }
}
