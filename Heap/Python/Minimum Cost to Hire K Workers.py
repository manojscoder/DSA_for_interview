# Problem link: https://leetcode.com/problems/minimum-cost-to-hire-k-workers/description/
# Time: O(nlogn)
# Space: O(n)
class Solution:
    def mincostToHireWorkers(self, quality: List[int], wage: List[int], k: int) -> float:
        ratio, maxHeap, total_quality, res = [], [], 0, inf

        for i in range(len(quality)):
            ratio.append((wage[i] / quality[i], quality[i]))
        
        ratio.sort()

        for rate, quality in ratio:
            heapq.heappush(maxHeap, -quality)
            total_quality += quality
            
            if len(maxHeap) == k:
                res = min(res, rate * total_quality)
                total_quality += heapq.heappop(maxHeap)

        return res
        
