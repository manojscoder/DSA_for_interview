// Problem link: https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/
// Time: O(n)
// space: O(1)
class Solution {
    public int minChanges(String s) {
        int result = 0;

        for(int index = 0; index < s.length(); index += 2) {
            if(s.charAt(index) != s.charAt(index + 1)) {
                result++;
            }
        }

        return result;
    }
}
