# Problem link: https://leetcode.com/problems/meeting-rooms-ii/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals.sort()
        minHeap = []

        for start, end in intervals:
            if minHeap and minHeap[0] < start:
                heapq.heappop(minHeap)
            
            heapq.heappush(minHeap, end)

        return len(minHeap)
            
