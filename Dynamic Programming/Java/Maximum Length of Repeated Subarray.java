// Problem link: https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/
// Time: O(n * m)
// Space: O(n * m)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int rows = nums1.length, cols = nums2.length, result = 0;
        int[][] DP = new int[rows + 1][cols + 1];

        for(int row = 0; row < rows; row++) {
            for(int col = 0; col < cols; col++) {
                if(nums1[row] == nums2[col]) {
                    DP[row + 1][col + 1] = DP[row][col] + 1;
                }
                result = Math.max(result, DP[row + 1][col + 1]);
            }
        }

        return result;
    }
}
