# Problem link: https://leetcode.com/problems/maximum-xor-for-each-query/description
# Time: O(n)
# Space: O(1)
class Solution:
    def getMaximumXor(self, nums: List[int], maximumBit: int) -> List[int]:
        XOR, mask, result = 0, (1 << maximumBit) - 1, []

        for num in nums:
            XOR ^= num
        
        for index in range(len(nums) - 1, -1, -1):
            result.append(XOR ^ mask)
            XOR ^= nums[index]
        
        return result
