# Problem link: https://leetcode.com/problems/single-number-ii/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        store = [0] * 32
        result = 0

        for num in nums:
            for pos in range(32):
                if num & (1 << pos):
                    store[pos] += 1
        
        for index in range(32):
            store[index] %= 3
            if store[index]:
                result += (2 ** index)

        return result if result < (1 << 31) else result - (1 << 32)
