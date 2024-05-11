# Problem link: https://leetcode.com/problems/maximum-subsequence-score/description/
# Time: O(nlogn)
# Space: O(n)

class Solution:
    def maxScore(self, nums1: List[int], nums2: List[int], k: int) -> int:
        store, minHeap, res, total = [], [], -inf, 0

        for i in range(len(nums1)):
            store.append((nums2[i], nums1[i]))
        
        store.sort(reverse = True)

        for p1, p2 in store:
            heapq.heappush(minHeap, p2)
            total += p2
            
            if len(minHeap) == k:
                res = max(res, p1 * total)
                total -= heapq.heappop(minHeap)
        
        return res
