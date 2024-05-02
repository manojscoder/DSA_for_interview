// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/length-of-last-word/description/
class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int i = s.length() - 1;
        while(i >= 0 && (len == 0 || s.charAt(i) != ' ')){
            if(s.charAt(i--) != ' '){
                len++;
            }
        }
        return len;
    }
}
