# Problem link: https://leetcode.com/problems/minimum-total-distance-traveled/description
# Time: O(n ^ 2 * m)
# Space: O(n * m)
class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort()
        factories = []

        for fact in factory:
            factories.extend([fact[0]] * fact[1])
        
        memo = [[-1] * len(factories) for _ in range(len(robot))]
        
        return self.dfs(robot, factories, 0, 0, memo)
        

    def dfs(self, robot, factories, factIdx, robIdx, memo):
        if robIdx == len(robot):
            return 0
        elif factIdx == len(factories):
            return float('inf')
        elif memo[robIdx][factIdx] != -1:
            return memo[robIdx][factIdx]
        
        include = abs(factories[factIdx] - robot[robIdx]) + self.dfs(robot, factories, factIdx + 1, robIdx + 1, memo)
        exclude = self.dfs(robot, factories, factIdx + 1, robIdx, memo)

        memo[robIdx][factIdx] = min(include, exclude)
        return min(include, exclude)
