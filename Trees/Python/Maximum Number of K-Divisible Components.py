# Problem link: https://leetcode.com/problems/maximum-number-of-k-divisible-components/description
# Time: O(n + m)
# Space: O(n + m)
class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:
        adjList, result = [[] for _ in range(n)], 0

        for u, v in edges:
            adjList[u].append(v)
            adjList[v].append(u)
        

        def dfs(par, node):
            nonlocal result
            total = values[node]

            for nei in adjList[node]:
                if nei != par:
                    total += dfs(node, nei)
            
            if total % k == 0:
                result += 1
                return 0
            
            return total

        dfs(-1, 0)

        return result
