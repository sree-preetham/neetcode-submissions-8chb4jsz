class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while(i < j){
            if(Character.isLetter(s.charAt(i))==false && (s.charAt(i) < '0' || s.charAt(i) > '9')){
                i++;
                continue;
            } 
            if(Character.isLetter(s.charAt(j))==false && (s.charAt(j) < '0' || s.charAt(j) > '9')){
                j--;
                continue;
            } 
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }
}