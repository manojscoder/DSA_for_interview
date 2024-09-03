// Problem link: https://leetcode.com/problems/sum-of-subarray-ranges/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public long subArrayRanges(int[] nums) {
        return this.sumSub(nums, true) - this.sumSub(nums, false);
    }

    private long sumSub(int[] nums, boolean flag) {
        Stack<int[]> stack = new Stack<>();
        long result = 0;
        int left, right;

        for(int idx = 0; idx < nums.length; idx++) {
            while(!stack.isEmpty() && (flag ? stack.peek()[1] < nums[idx] : stack.peek()[1] > nums[idx])) {
                int[] popPair = stack.pop();
                left = stack.isEmpty() ? popPair[0] + 1 : popPair[0] - stack.peek()[0];
                right = idx - popPair[0];
                result += (long)right * left * popPair[1];  
            }
            stack.push(new int[] {idx, nums[idx]});
        }

        while(!stack.isEmpty()) {
            int[] popPair = stack.pop();
            left = stack.isEmpty() ? popPair[0] + 1 : popPair[0] - stack.peek()[0];
            right = nums.length - popPair[0];
            result += (long)right * left * popPair[1];  
        }

        return result;
    }
}
