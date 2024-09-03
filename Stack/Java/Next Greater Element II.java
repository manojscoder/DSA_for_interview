// Problem link: https://leetcode.com/problems/next-greater-element-ii/description/ 
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int size = nums.length;
        int[] result = new int[size];
        Stack<Integer> stack = new Stack<>();

        for(int idx = size * 2 - 1; idx >= 0; idx--) {

            while(!stack.isEmpty() && stack.peek() <= nums[idx % size]) {
                stack.pop();
            }

            if(idx < size) {
                result[idx] = !stack.isEmpty() ? stack.peek() : -1;
            }

            stack.push(nums[idx % size]);
        }

        return result;
    }
}
