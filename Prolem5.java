Problem : Find the Longest Common Prefix in the given String array.

Solution:

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(strs==null||n==0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i<n; i++){
            while(!strs[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
            }
            if(prefix.isEmpty()){
                return "";
            }
        }
        return prefix;

    }
}
