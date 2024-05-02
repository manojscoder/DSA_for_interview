# Time: O(n)
# Space: O(1)
# Problem link: https://leetcode.com/problems/length-of-last-word/description/
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        result = 0
        i = len(s) - 1
        while i >= 0 and (result == 0 or s[i] != ' '):
            if s[i] != ' ':
                result += 1
            i -= 1
        
        return result
