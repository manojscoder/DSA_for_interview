# Problem link: https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        size = 2 ** n - 1
        flag = False

        while size > 1:
            half = size // 2
            if half >= k:
                size = half
            elif half + 1 < k:
                k = 1 + size - k
                size = half
                flag = not flag
            else:
                return '1' if not flag else '0'
    
        return '0' if not flag else '1'
