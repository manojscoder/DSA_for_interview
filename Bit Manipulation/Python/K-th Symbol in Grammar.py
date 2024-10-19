# Problem link: https://leetcode.com/problems/k-th-symbol-in-grammar/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def kthGrammar(self, n: int, k: int) -> int:
        left, right = 0, 2 ** (n - 1) - 1
        result = 0
        
        for _ in range(n - 1):
            mid = (left + right) // 2

            if mid >= k - 1:
                right = mid
            else:
                left = mid + 1
                result = 0 if result else 1

        return result
