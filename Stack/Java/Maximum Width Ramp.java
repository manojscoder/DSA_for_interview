// Problem link: https://leetcode.com/problems/maximum-width-ramp/description
// Time: O(n)
// Space: O(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        int[] store = new int[nums.length + 1];
        int result = 0, left = 0, right = 1;

        for(int idx = nums.length - 1; idx >= 0; idx--) {
            store[idx] = Math.max(store[idx + 1], nums[idx]);
        }

        while(right < nums.length) {
            if(store[right] >= nums[left]) {
                result = Math.max(result, right++ - left);
            }
            else {
                left++;
            }
        }

        return result;
    }
}
