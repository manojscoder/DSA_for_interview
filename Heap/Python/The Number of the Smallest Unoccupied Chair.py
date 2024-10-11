# Problem link: https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description
# Time: O(n log n)
# Space: O(n)
class Solution:
    def smallestChair(self, times: List[List[int]], targetFriend: int) -> int:
        indexes = sorted([idx for idx in range(len(times))], key = lambda x : times[x][0])
        minHeapOne, minHeapTwo = [time for time in range(len(times))], []

        for idx in indexes:
            while minHeapTwo and minHeapTwo[0][0] <= times[idx][0]:
                heapq.heappush(minHeapOne, heapq.heappop(minHeapTwo)[1])
            
            chair = heapq.heappop(minHeapOne)

            if idx == targetFriend:
                return chair
            
            heapq.heappush(minHeapTwo, (times[idx][1], chair))

        return -1
