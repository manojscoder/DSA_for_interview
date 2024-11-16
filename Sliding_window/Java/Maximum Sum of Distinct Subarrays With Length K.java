// Problem link: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> store = new HashSet<>();
        int left = 0, right = 0;
        long result = 0, count = 0;

        while(right < nums.length) {
            while(left < right && store.contains(nums[right])) {
                store.remove(nums[left]);
                count -= nums[left];
                left++;
            }

            store.add(nums[right]);
            count += nums[right];

            if(right - left + 1 == k) {
                result = Math.max(result, count);
                count -= nums[left];
                store.remove(nums[left]);
                left++;
            }

            right++;
        }

        return result;
    }
}
