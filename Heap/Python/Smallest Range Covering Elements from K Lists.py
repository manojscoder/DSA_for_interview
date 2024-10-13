# Problem link: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description
# Time: O(n log k)
# Space: O(k)
class Solution:
    def smallestRange(self, nums: List[List[int]]) -> List[int]:
        minHeap, maxNum, small, large, size = [], -1, 0, 0, float('inf')

        for idx, arr in enumerate(nums):
            minHeap.append((arr[0], 0, idx))
            maxNum = max(maxNum, arr[0])

        heapq.heapify(minHeap)

        while len(minHeap) >= len(nums):
            if size > maxNum - minHeap[0][0]:
                size = maxNum - minHeap[0][0]
                small, large = minHeap[0][0], maxNum

            value, ptr, idx = heapq.heappop(minHeap)

            if ptr + 1 < len(nums[idx]):
                newVal = nums[idx][ptr + 1]
                maxNum = max(maxNum, newVal)
                heapq.heappush(minHeap, (newVal, ptr + 1, idx))
        
        return [small, large]
