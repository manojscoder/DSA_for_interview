// Problem link: https://leetcode.com/problems/uncrossed-lines/description/
// Time: O(n * m)
// Space: O(m)
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int rows = nums1.length, cols = nums2.length;
        int[] curr = new int[cols + 1], prev = new int[cols + 1];

        for(int row = rows - 1; row >= 0; row--) {
            for(int col = cols - 1; col >= 0; col--) {
                if(nums1[row] == nums2[col]) {
                    curr[col] = 1 + prev[col + 1];
                }
                else {
                    curr[col] = Math.max(prev[col], curr[col + 1]);
                }
            }

            for(int col = 0; col < cols; col++) {
                prev[col] = curr[col];
            }
        }

        return prev[0];
    }
}
