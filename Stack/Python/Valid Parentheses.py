# Time: O(n)
# Space: O(n)
# Problem link: https://leetcode.com/problems/valid-parentheses/description/

class Solution:
    def isValid(self, s):
        stack = []
        
        for c in s:
            if c == '{' or c == '[' or c == '(':
                stack.append(c)
            elif not stack or (c == '}' and stack.pop() != '{') or (c == ']' and stack.pop() != '[') or (c == ')' and stack.pop() != '('):
                return False
        
        return len(stack) == 0
