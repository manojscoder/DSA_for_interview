# Problem link: https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description

# Approach: 1
# Time: O(n * m), where n is the number of alphabets in input and m is the number of pairs of parentheses
# Space: O(n)
class Solution:
    def reverseParentheses(self, s: str) -> str:
        stack, queue = [], []

        for char in s:
            if char == ')':
                while stack[-1] != '(':
                    queue.append(stack.pop())

                stack.pop()

                while queue:
                    stack.append(queue.pop(0))
            else:
                stack.append(char)
        
        return "".join(stack)

  # Approach: 2
  # Time: O(n), where n is the length of the input
  # Space: O(n)
  class Solution:
    def reverseParentheses(self, s: str) -> str:
        pair, stack = {}, []
        index, result, direction = 0, [], 1

        for idx, char in enumerate(s):
            if char == '(':
                stack.append(idx)
            elif char == ')':
                pair[stack[-1]] = idx
                pair[idx] = stack.pop()
        
        while index < len(s):
            if s[index] == '(' or s[index] == ')':
                index = pair[index]
                direction *= -1
            else:
                result.append(s[index])
            index += direction
        
        return "".join(result)
