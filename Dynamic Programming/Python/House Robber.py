# Problem link: https://leetcode.com/problems/house-robber/description/

# Top-down approach
# Time: O(n)
# Space: O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        cache = [-1] * len(nums)

        def DP(index):
            if cache[index] != -1:
                return cache[index]
            
            max_amount = 0
            for i in range(index + 2, len(nums)):
                max_amount = max(max_amount, DP(i))

            cache[index] = max_amount + nums[index]
            return cache[index]
        
        for i in range(min(2, len(nums))):
            cache[i] = DP(i)

        return max(cache[0], cache[1] if len(cache) > 1 else 0)

# Bottom-up approach
# Time: O(n)
# Space: O(n)
class Solution:
    def rob(self, nums: List[int]) -> int:
        if len(nums) <= 2:
            return max(nums)
        
        DP = nums + [0]

        for i in range(len(nums) - 3, -1, -1):
            DP[i] += max(DP[i + 2], DP[i + 3])
        
        return max(DP[0], DP[1])

# Space optimized
# Time: O(n)
# Space: O(1)
class Solution:
    def rob(self, nums: List[int]) -> int:
        one, two = 0, 0

        for n in nums:
            one, two = two, max(one + n, two)
        
        return two
