# Time: O(n log n)
# Space: O(n)
# Problem link: https://leetcode.com/problems/car-fleet/description/
class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = sorted([(position[i], speed[i]) for i in range(len(position))])[::-1]
        stack = []

        for pos, spd in pair:
            stack.append((target - pos) / spd)
            if len(stack) >= 2 and stack[-1] <= stack[-2]:
                stack.pop()
        
        return len(stack)
