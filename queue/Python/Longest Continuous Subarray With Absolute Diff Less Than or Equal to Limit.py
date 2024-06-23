# Problem link: https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/description/?
# Time: O(n)
# Space: O(n)
class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        minQueue, maxQueue, left, result = deque(), deque(), 0, 0

        for right in range(len(nums)):

            while minQueue and minQueue[-1] > nums[right]:
                minQueue.pop()
            
            minQueue.append(nums[right])
            
            while maxQueue and maxQueue[-1] < nums[right]:
                maxQueue.pop()
            
            maxQueue.append(nums[right])

            while maxQueue[0] - minQueue[0] > limit:

                if nums[left] == minQueue[0]:
                    minQueue.popleft()
                
                if nums[left] == maxQueue[0]:
                    maxQueue.popleft()
                
                left += 1
            
            result = max(result, right - left + 1)
        
        return result
