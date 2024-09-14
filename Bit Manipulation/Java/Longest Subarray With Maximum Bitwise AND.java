// Problem link: https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int longestSubarray(int[] nums) {
        int result = 0, curr = 0, count = 0;

        for(int num : nums) {
            if(curr < num) {
                curr = num;
                count = result = 0;
            }

            count = curr == num ? count + 1 : 0;
            result = Math.max(result, count);
        }

        return result;
    }
}
