// Problem link: https://leetcode.com/problems/minimum-array-end/description
// Time: O(n)
// Space: O(1)
class Solution {
    public long minEnd(int n, int x) {
        long result = x;

        for(int idx = 0; idx < n - 1; idx++) {
            result = (result + 1) | x;
        }

        return result;
    }
}
