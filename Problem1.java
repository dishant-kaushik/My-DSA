Problem: Longest Palindromic Substring

Solution:
public class Solution {   
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0){
            return "";
        }      
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = 0;        
        for (int i = 0; i < n; i++) {
            int len1 = expandAroundCenter(charArray, i, i);
            int len2 = expandAroundCenter(charArray, i, i + 1);
            int maxLength = Math.max(len1, len2);           
            if (maxLength > end - start) {
                start = i - (maxLength - 1) / 2;
                end = i + maxLength / 2;
            }
        }       
        return s.substring(start, end + 1);
    }   
    private int expandAroundCenter(char[] charArray, int left, int right) {
        while (left >= 0 && right < charArray.length && charArray[left] == charArray[right]) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}

