# Problem link: https://leetcode.com/problems/count-number-of-nice-subarrays/description/?
# Time: O(n)
# Space: O(1)
class Solution:
    def numberOfSubarrays(self, nums: List[int], k: int) -> int:
        result = left = middle = odd = 0

        for right in range(len(nums)):
            if nums[right] % 2:
                odd += 1
            
            while odd > k:
                if nums[left] % 2:
                    odd -= 1
                left += 1
                middle = left
            
            if odd == k:
                while not nums[middle] % 2:
                    middle += 1
                result += middle - left + 1
        
        return result
