# Problem link: https://leetcode.com/problems/minimum-string-length-after-removing-substrings/description
# Time: O(n)
# Space: O(n)
class Solution:
    def minLength(self, s: str) -> int:
        stack = ['0']

        for char in s:
            if char == 'D' and stack[-1] == 'C':
                stack.pop()
            elif char == 'B' and stack[-1] == 'A':
                stack.pop()
            else:
                stack.append(char)
        
        return len(stack) - 1
