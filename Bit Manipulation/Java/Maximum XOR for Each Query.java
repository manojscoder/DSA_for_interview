// Problem link: https://leetcode.com/problems/maximum-xor-for-each-query/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int mask = (1 << maximumBit) - 1, XOR = 0;
        int[] result = new int[nums.length];

        for(int num : nums) {
            XOR ^= num;
        }

        for(int index = 0; index < nums.length; index++) {
            result[index] = XOR ^ mask;
            XOR ^= nums[nums.length - index - 1];
        }

        return result;
    }
}
