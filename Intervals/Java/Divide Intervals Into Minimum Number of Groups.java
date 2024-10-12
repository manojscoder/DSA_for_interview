// Problem link: https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description 
// Time: O(n + k)
// Space: O(k)
class Solution {
    public int minGroups(int[][] intervals) {
        int minStart = Integer.MAX_VALUE, maxEnd = 0, result = 0, prefix = 0;

        for(int[] pair : intervals) {
            minStart = Math.min(minStart, pair[0]);
            maxEnd = Math.max(maxEnd, pair[1]);
        }

        int[] store = new int[maxEnd + 1];

        for(int[] pair : intervals) {
            store[pair[0] - 1]++;
            store[pair[1]]--;
        }
        
        for(int point = minStart - 1; point <= maxEnd; point++) {
            prefix += store[point];
            result = Math.max(prefix, result);
        }

        return result;
    }
}
