# Problem link: https://leetcode.com/problems/best-sightseeing-pair/description
# Time: O(n)
# Space: O(1)
class Solution:
    def maxScoreSightseeingPair(self, values: List[int]) -> int:
        currVal, result = values[0] - 1, 0

        for index in range(1, len(values)):
            result = max(result, currVal + values[index])
            currVal = max(currVal - 1, values[index] - 1)
        
        return result
