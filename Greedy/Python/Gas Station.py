# Problem link: https://leetcode.com/problems/gas-station/description/
# Time: O(n)
# Space: O(1)
class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) < sum(cost):
            return -1

        startIdx, total = -1, 0

        for i in range(len(gas)):
            total += (gas[i] - cost[i])

            if total >= 0 and startIdx == -1:
                startIdx = i
            elif total < 0:
                total = 0
                startIdx = -1
        
        return startIdx

