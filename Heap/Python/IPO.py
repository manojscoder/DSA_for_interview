# Problem link: https://leetcode.com/problems/ipo/description/
# Time: O(nlogn)
# Space: O(n)
class Solution:
    def findMaximizedCapital(self, k: int, w: int, profits: List[int], capital: List[int]) -> int:
        maxHeap, idx = [], 0

        store = sorted([(c, p) for c, p in zip(capital, profits)])

        for i in range(k):

            while idx < len(store) and store[idx][0] <= w:
                heapq.heappush(maxHeap, -store[idx][1])
                idx += 1
            
            if not maxHeap:
                break
            
            w -= heapq.heappop(maxHeap)
        
        return w
