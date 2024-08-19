// Problem link: https://leetcode.com/problems/longest-increasing-subsequence/description/
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int result = 0, size = nums.length;
        int[] DP = new int[size];

        for(int i = size - 1; i >= 0; i--) {
            DP[i] = 1;
            for(int j = i + 1; j < size; j++) {
                if(nums[i] < nums[j]) {
                    DP[i] = Math.max(DP[i], 1 + DP[j]);
                }
            }
            result = Math.max(result, DP[i]);
        }

        return result;
    }
}
