# Problem link: https://leetcode.com/problems/maximal-score-after-applying-k-operations/description
# Time: O(k log n)
# Space: O(n)
class Solution:
    def maxKelements(self, nums: List[int], k: int) -> int:
        score = 0
        maxHeap = [-num for num in nums]
        heapq.heapify(maxHeap)

        for _ in range(k):
            score += -maxHeap[0]
            heapq.heappush(maxHeap, floor(heapq.heappop(maxHeap) / 3))
        
        return score
