# Problem link: https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/description
# Time: O(n)
# Space: O(1)
class Solution:
    def minSwaps(self, s: str) -> int:
        count = result = 0

        for char in s:
            if char == ']':
                count += 1
            else:
                count -= 1
            result = max(result, count)
        
        return (result + 1) // 2
