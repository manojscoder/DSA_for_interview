# Problem link: https://leetcode.com/problems/make-sum-divisible-by-p/description
# Time: O(n)
# Space: O(n)
class Solution:
    def minSubarray(self, nums: List[int], p: int) -> int:
        total = sum(nums)
        remainder = total % p

        if not remainder:
            return 0

        result, curr_sum = float('inf'), 0
        mapping = {0 : -1}

        for idx, num in enumerate(nums):
            curr_sum = (curr_sum + num) % p
            prefix = (curr_sum - remainder + p) % p
            if prefix in mapping:
                result = min(result, idx - mapping[prefix])
            mapping[curr_sum] = idx
        
        return -1 if result == len(nums) else result
