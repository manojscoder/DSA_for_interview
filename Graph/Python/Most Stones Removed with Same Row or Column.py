# Problem link: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description
# Time: O(n ^ 2)
# Space: O(n)
class Solution:
    def removeStones(self, stones: List[List[int]]) -> int:
        num, result = len(stones), 0
        visit = [0] * num

        for node in range(num):
            if not visit[node]:
                self.dfs(node, num, stones, visit)
                result += 1
        
        return num - result


    def dfs(self, node, num, stones, visit):
        visit[node] = 1

        for nei in range(num):
            if not visit[nei]:
                if stones[node][0] == stones[nei][0]:
                    self.dfs(nei, num, stones, visit)
                if stones[node][1] == stones[nei][1]:
                    self.dfs(nei, num, stones, visit)
