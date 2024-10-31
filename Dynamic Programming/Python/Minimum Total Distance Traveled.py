# Problem link: https://leetcode.com/problems/minimum-total-distance-traveled/description

# Approach: DP (Memo)
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

# Approach: DP Tabulation
# Time: O(n ^ 2 * m)
# Space: O(n * m)
class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort()

        factories = []

        for fact in factory:
            factories.extend([fact[0]] * fact[1])
        
        robotCount, factoryCount = len(robot), len(factories)
        DP = [[0] * (factoryCount + 1) for _ in range(robotCount + 1)]

        for row in range(robotCount):
            DP[row][factoryCount] = float('inf')

        for row in range(robotCount - 1, -1, -1):
            for col in range(factoryCount - 1, -1, -1):
                include = abs(robot[row] - factories[col]) + DP[row + 1][col + 1]
                exclude = DP[row][col + 1]

                DP[row][col] = min(include, exclude)
        
        return DP[0][0]

# Approach: DP Space optimized
# Time: O(n ^ 2 * m)
# Space: O(m)
class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        robot.sort()
        factory.sort()

        factories = []

        for fact in factory:
            factories.extend([fact[0]] * fact[1])
        
        robotCount, factoryCount = len(robot), len(factories)
        prev, curr = [0] * (factoryCount + 1), [0] * (factoryCount + 1)
        curr[factoryCount] = float('inf')

        for row in range(robotCount - 1, -1, -1):
            
            for col in range(factoryCount - 1, -1, -1):
                include = abs(robot[row] - factories[col]) + prev[col + 1]
                exclude = curr[col + 1]

                curr[col] = min(include, exclude)
            
            for col in range(factoryCount):
                prev[col], curr[col] = curr[col], 0
                
            prev[factoryCount] = float('inf')
        
        return prev[0]
