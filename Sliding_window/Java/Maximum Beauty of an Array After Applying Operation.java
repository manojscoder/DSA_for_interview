// Problem link: https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/description/
// Time: O(n log n)
// Space: O(1)
class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0, left = 0, right = 0;

        while(right < nums.length) {
            while(nums[right] - nums[left] > 2 * k) {
                left++;
            }

            result = Math.max(result, right++ - left + 1);
        }

        return result;
    }
}
