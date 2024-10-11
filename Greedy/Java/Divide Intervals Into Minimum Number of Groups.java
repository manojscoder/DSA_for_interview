// Problem link: https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/
// Time: O(n + k)
// Space: O(k)
class Solution {
    public int minGroups(int[][] intervals) {
        int minStart = Integer.MAX_VALUE, maxEnd = Integer.MIN_VALUE, result = 0, prefix = 0;

        for(int[] interval : intervals) {
            minStart = Math.min(interval[0], minStart);
            maxEnd = Math.max(interval[1], maxEnd);
        }

        int[] lineSweep = new int[maxEnd + 1];

        for(int[] interval : intervals) {
            lineSweep[interval[0] - 1]++;
            lineSweep[interval[1]]--;
        }

        for(int point = minStart - 1; point <= maxEnd; point++) {
            prefix += lineSweep[point];
            result = Math.max(prefix, result);
        }

        return result;
    }
}
