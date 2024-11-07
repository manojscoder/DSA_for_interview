// Problem link: https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int largestCombination(int[] candidates) {
        int result = 0, count;

        for(int index = 0; index < 32; index++) {
            count = 0;

            for(int num : candidates) {
                if(((1 << index) & num) != 0) {
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        return result;
    }
}
