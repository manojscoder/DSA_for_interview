// Problem link: https://leetcode.com/problems/merge-intervals/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for(int idx = 1; idx < intervals.length; idx++) {
            int prev = result.getLast()[1];

            if(intervals[idx][0] <= prev) {
                result.getLast()[1] = Math.max(prev, intervals[idx][1]);
            }
            else {
                result.add(intervals[idx]);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }
}
