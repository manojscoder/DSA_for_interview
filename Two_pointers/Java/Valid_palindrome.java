// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/valid-palindrome/description/

class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toCharArray();
        int i = 0, j = s.length() - 1;

        while(i < j){
            while(i < j && !Character.isLetterOrDigit(str[i])){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(str[j])){
                j--;
            }
            if(Character.toLowerCase(str[i]) != Character.toLowerCase(str[j])){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
