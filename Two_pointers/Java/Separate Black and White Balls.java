// Problem link: https://leetcode.com/problems/separate-black-and-white-balls/description
// Time: O(n)
// Space: O(1)
class Solution {
    public long minimumSteps(String s) {
        long result = 0;
        int count = 0;

        for(int idx = 0; idx < s.length(); idx++) {
            if(s.charAt(idx) == '0') {
                result += (idx - count);
                count++;
            }
        }

        return result;
    }
}
