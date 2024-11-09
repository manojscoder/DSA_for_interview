# Problem link: https://leetcode.com/problems/minimum-array-end/description
# Time: O(n)
# Space: O(1)
class Solution:
    def minEnd(self, n: int, x: int) -> int:
        result = x

        for _ in range(n - 1):
            result = (result + 1) | x
        
        return result
