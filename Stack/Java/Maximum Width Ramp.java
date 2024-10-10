// Problem link: https://leetcode.com/problems/maximum-width-ramp/description
// Time: O(n)
// Space: O(n)
class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int idx = 0; idx < nums.length; idx++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[idx]) {
                stack.push(idx);
            }
        }

        for(int idx = nums.length - 1; idx >= 0; idx--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[idx]) {
                result = Math.max(result, idx - stack.peek());
                stack.pop();
            }
        }

        return result;
    }
}
