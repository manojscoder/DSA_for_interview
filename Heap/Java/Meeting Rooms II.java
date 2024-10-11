// Problem link: https://leetcode.com/problems/meeting-rooms-ii/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int[] pair : intervals) {
            if(!minHeap.isEmpty() && minHeap.peek() < pair[0]) {
                minHeap.poll();
            }

            minHeap.add(pair[1]);
        }

        return minHeap.size();
    }
}
