# Problem link: https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i/description
# Time: O(n)
# Space: O(1)
class Solution:
    def resultsArray(self, nums: List[int], k: int) -> List[int]:
        if k == 1:
            return nums
        
        counter = 1
        result = [-1] * (len(nums) - k + 1)

        for index in range(len(nums) - 1):
            if nums[index] + 1 == nums[index + 1]:
                counter += 1
            else:
                counter = 1
            
            if counter >= k:
                result[index - k + 2] = nums[index + 1]
        
        return result
            
