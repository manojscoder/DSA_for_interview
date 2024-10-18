// Problem link: https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/description
// Time: O(2 ^ n)
// Space: O(n)
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int val = 0;
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        for(int num : nums) {
            val |= num;
        }

        return this.dfs(0, nums, val, 0, memo);
    }

    private int dfs(int idx, int[] nums, int val, int orVal, int[] memo) {
        if(idx == nums.length) {
            return orVal == val ? 1 : 0;
        }

        int with = this.dfs(idx + 1, nums, val, orVal | nums[idx], memo);
        int without = this.dfs(idx + 1, nums, val, orVal, memo);
        return m
    }
}
