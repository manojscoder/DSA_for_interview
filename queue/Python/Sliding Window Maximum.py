# Problem link: https://leetcode.com/problems/sliding-window-maximum/
# Time: O(n)
# Space: O(n)
class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        queue, left, result = deque(), 0, []

        for right in range(len(nums)):
            while queue and queue[-1] < nums[right]:
                queue.pop()
            
            queue.append(nums[right])

            if right - left + 1 == k:
                result.append(queue[0])

                if queue[0] == nums[left]:
                    queue.popleft()
                
                left += 1
                
        return result
