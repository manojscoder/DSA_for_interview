# Problem link: https://leetcode.com/problems/divide-intervals-into-minimum-number-of-groups/description
# Time: O(n + k)
# Space: O(k)
class Solution:
    def minGroups(self, intervals: List[List[int]]) -> int:
        minStart, maxEnd, result, prefix = float('inf'), 0, 0, 0

        for start, end in intervals:
            minStart = min(start, minStart)
            maxEnd = max(end, maxEnd)
        
        store = [0] * (maxEnd + 1)

        for start, end in intervals:
            store[start - 1] += 1
            store[end] -= 1
        
        for point in range(maxEnd + 1):
            prefix += store[point]
            result = max(result, prefix)
        
        return result
