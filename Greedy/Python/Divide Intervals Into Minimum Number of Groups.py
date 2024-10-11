# Problem link: https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description/
# Time: O(n + k)
# Space: O(k)
class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        minStart = float('inf')
        maxEnd = float('-inf')

        for start, end in intervals:
            minStart = min(minStart, start)
            maxEnd = max(maxEnd, end)
        
        lineSweep = [0] * (maxEnd + 1)

        for start, end in intervals:
            lineSweep[start - 1] += 1
            lineSweep[end] -= 1
        
        result = prefix = 0

        for point in range(minStart - 1, maxEnd + 1):
            prefix += lineSweep[point]
            result = max(result, prefix)
        
        return result
