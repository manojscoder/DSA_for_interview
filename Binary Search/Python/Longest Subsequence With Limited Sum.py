# Problem link: https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def answerQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        nums.sort()
        result = []

        for idx in range(1, len(nums)):
            nums[idx] += nums[idx - 1]

        for num in queries:
            answer, left, right = -1, 0, len(nums) - 1

            while left <= right:
                mid = (left + right) // 2

                if nums[mid] <= num:
                    answer = mid
                    left = mid + 1
                else:
                    right = mid - 1
            
            result.append(answer + 1)
        
        return result
