# Problem link: https://leetcode.com/problems/largest-combination-with-bitwise-and-greater-than-zero/description
# Time: O(n)
# Space: O(1)
class Solution:
    def largestCombination(self, candidates: List[int]) -> int:
        result = 0

        for idx in range(32):
            count = 0
            for num in candidates:
                if (1 << idx) & num:
                    count += 1
            result = max(count, result)
        
        return result
