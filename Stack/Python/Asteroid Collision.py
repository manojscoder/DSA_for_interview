# Problem link: https://leetcode.com/problems/asteroid-collision/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def asteroidCollision(self, asteroids: List[int]) -> List[int]:
        stack = []

        for ast in asteroids:
            while ast < 0 and stack and stack[-1] > 0:
                if ast + stack[-1] > 0:
                    ast = 0
                elif ast + stack[-1] < 0:
                    stack.pop()
                else:
                    ast = 0
                    stack.pop()
            if ast:
                stack.append(ast)
        
        return stack
