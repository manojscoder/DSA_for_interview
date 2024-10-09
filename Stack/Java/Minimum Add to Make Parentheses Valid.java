// Problem link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0, result = 0;

        for(char chr : s.toCharArray()) {
            if(chr == '(') {
                count++;
            }
            else {
                if(count > 0) {
                    count--;
                }
                else {
                    result++;
                }
            }
        }

        return result + count;
    }
}
