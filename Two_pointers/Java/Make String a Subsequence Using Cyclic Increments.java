// Problem link: https://leetcode.com/problems/make-string-a-subsequence-using-cyclic-increments/description
// Time: O(n)
// Space: O(1)
class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int index = 0, value;

        for(int idx = 0; idx < str1.length(); idx++) {
            value = (int)str1.charAt(idx);

            if(value == (int)str2.charAt(index) || (str1.charAt(idx) == 'z' ? (int)'a' : value + 1) == (int)str2.charAt(index)) {
                index++;
            }

            if(index == str2.length()) {
                return true;
            }
        }

        return false;
    }
}
