# Problem link: https://leetcode.com/problems/longest-cycle-in-a-graph/description/
# Time: O(n)
# Space: O(n)
class Solution:
    def longestCycle(self, edges: List[int]) -> int:
        visit, result = [0] * len(edges), -1

        for node in range(len(edges)):
            if not visit[node]:
                result = max(result, self.dfs(node, edges, visit, 1, -1))
        
        return result
    
    def dfs(self, node, edges, visit, dist, maxDist):
        if visit[node]:
            return dist - visit[node] if visit[node] > 0 else -1

        visit[node] = dist

        if edges[node] != -1:
            maxDist = max(maxDist, self.dfs(edges[node], edges, visit, dist + 1, maxDist))

        visit[node] = -1
        return maxDist
