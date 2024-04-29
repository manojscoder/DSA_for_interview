// Time: O(n)
// Space: O(1)
// Problem link: https://leetcode.com/problems/valid-palindrome-ii/description/
class Solution {
    public boolean validPalindrome(String s) {
        int i = 0,j = s.length() - 1;
        char[] c = s.toCharArray();
        while(i < j){
            if(c[i] != c[j]){
                return isPalin(c,i,j - 1) || isPalin(c,i + 1,j);
            }
            i++;
            j--;
        }
        return true;
    }

    boolean isPalin(char[] c,int i,int j){
        while(i < j){
            if(c[i++] != c[j--]){
                return false;
            }
        }
        return true;
    }
}
