# Problem link: https://leetcode.com/problems/k-closest-points-to-origin/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        minHeap = []
        result = []

        for p1, p2 in points:
            heapq.heappush(minHeap, (math.sqrt(p1 ** 2 + p2 ** 2), p1, p2))
        
        while k > 0:
            detail = heapq.heappop(minHeap)
            result.append([detail[1], detail[2]])
            k -= 1
        
        return result
