// Problem link: https://leetcode.com/problems/house-robber-ii/description/
// Time: O(n)
// Space: O(1)
class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        return Math.max(this.helper(nums, 0, nums.length - 1), this.helper(nums, 1, nums.length));
    }

    private int helper(int[] nums, int left, int right) {
        int one = 0, two = 0, temp;

        for(int i = left; i < right; i++) {
            temp = two;
            two = Math.max(one + nums[i], two);
            one = temp;
        }
        
        return two;
    }
}
