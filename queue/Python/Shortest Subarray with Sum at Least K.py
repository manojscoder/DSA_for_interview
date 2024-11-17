# Problem link: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def shortestSubarray(self, nums: List[int], k: int) -> int:
        result, currSum = float('inf'), 0
        queue = deque()

        for index in range(len(nums)):
            currSum += nums[index]

            if currSum >= k:
                result = min(result, index + 1)
            
            while queue and currSum - queue[0][0] >= k:
                result = min(result, index - queue.popleft()[1])
            
            while queue and queue[-1][0] > currSum:
                queue.pop()
            
            queue.append((currSum , index))
        
        return -1 if result == float('inf') else result
