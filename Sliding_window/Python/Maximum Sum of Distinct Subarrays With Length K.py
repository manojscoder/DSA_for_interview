# Problem link: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def maximumSubarraySum(self, nums: List[int], k: int) -> int:
        result = left = right = count = 0
        store = set()

        while right < len(nums):
            while left < right and nums[right] in store:
                store.remove(nums[left])
                count, left = count - nums[left], left + 1
            
            store.add(nums[right])
            count += nums[right]
            
            if len(store) == k:
                result, count = max(result, count), count - nums[left]
                store.remove(nums[left])
                left += 1
            
            right += 1
        
        return result
