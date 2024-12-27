// Problem link: https://leetcode.com/problems/best-sightseeing-pair/description
// Time: O(n)
// Space: O(1)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result = 0, currVal = values[0] - 1;

        for(int index = 1; index < values.length; index++) {
            result = Math.max(result, currVal + values[index]);
            currVal = Math.max(currVal - 1, values[index] - 1);
        }

        return result;
    }
}
