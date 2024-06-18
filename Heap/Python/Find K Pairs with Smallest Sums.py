# Problem link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
# Time: O(n + k log m)
# Space: O(n + k)
class Solution:
    def kSmallestPairs(self, nums1, nums2, k):
        result, minHeap = [], []

        for i in nums1:
            heapq.heappush(minHeap, (i + nums2[0], 0))
        
        while k > 0 and minHeap:
            total, idx = heapq.heappop(minHeap)

            result.append([total - nums2[idx], nums2[idx]])

            if idx + 1 < len(nums2):
                heapq.heappush(minHeap, (total - nums2[idx] + nums2[idx + 1], idx + 1))
            
            k -= 1
        
        return result
