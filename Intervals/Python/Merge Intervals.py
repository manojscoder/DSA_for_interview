# Problem link: https://leetcode.com/problems/merge-intervals/description/
# Time: O(n log n)
# Space: O(n)
class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort()
        result = [intervals[0]]

        for start, end in intervals[1:]:
            prev = result[-1][1]

            if prev >= start:
                result[-1][1] = max(prev, end)
            else:
                result.append([start, end])
        
        return result
