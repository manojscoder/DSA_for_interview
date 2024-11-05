# Problem link: https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def minChanges(self, s: str) -> int:
        result = 0

        for index in range(0, len(s), 2):
            if s[index] != s[index + 1]:
                result += 1
        
        return result
