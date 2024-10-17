# Problem link: https://leetcode.com/problems/simplify-path/description
# Time: O(n)
# Space: O(n)
class Solution:
    def simplifyPath(self, path: str) -> str:
        stack = []

        for node in path.split('/'):
            if node:
                if node == '..':
                    if stack:
                        stack.pop()
                elif node != '.':
                    stack.append(node)

        return '/' + "/".join(stack)
