# Problem link: https://leetcode.com/problems/design-a-stack-with-increment-operation/description
# Time: O(1)
# Space: O(n)
class CustomStack:

    def __init__(self, maxSize: int):
        self.stack = [0] * maxSize
        self.inc = [0] * maxSize
        self.top = -1

    def push(self, x: int) -> None:
        if len(self.stack) > self.top + 1:
            self.top += 1
            self.stack[self.top] = x

    def pop(self) -> int:
        if self.top >= 0:
            value = self.stack[self.top] + self.inc[self.top]
            if self.top > 0:
                self.inc[self.top - 1] += self.inc[self.top]
            self.inc[self.top] = 0
            self.top -= 1
            return value
        return -1

    def increment(self, k: int, val: int) -> None:
        if self.top >= 0:
            index = min(k - 1, self.top)
            self.inc[index] += val
        
