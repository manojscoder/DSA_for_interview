// Problem link: https://leetcode.com/problems/sum-of-subarray-minimums/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int result = 0, MOD = 1000000007, left, right;
        Stack<int[]> stack = new Stack<>();

        for(int idx = 0; idx < arr.length; idx++) {

            while(!stack.isEmpty() && stack.peek()[1] > arr[idx]) {
                int[] popPair = stack.pop();
                left = !stack.isEmpty() ? popPair[0] - stack.peek()[0] : popPair[0] + 1;
                right = idx - popPair[0];
                result = (int)((result + (long) left * right * popPair[1]) % MOD);
            }

            stack.push(new int[] {idx, arr[idx]});
        }

        while(!stack.isEmpty()) {
            int[] popPair = stack.pop();
            left = !stack.isEmpty() ? popPair[0] - stack.peek()[0] : popPair[0] + 1;
            right = arr.length - popPair[0];
            result = (int)((result + (long) left * right * popPair[1]) % MOD);
        }

        return result;
    }
}
