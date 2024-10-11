# Problem link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        adjList = [[] for _ in range(n + 1)]
        visit = [False] * (n + 1)

        for u, v, w in roads:
            adjList[u].append([v, w])
            adjList[v].append([u, w])

        return self.dfs(1, visit, adjList, float('inf'))
    
    def dfs(self, node, visit, adjList, score):
        visit[node] = True

        for nei, wei in adjList[node]:
            if not visit[nei]:
                score = min(wei, score, self.dfs(nei, visit, adjList, score))
            else:
                score = min(score, wei)

        return score
