# Problem link: https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
# Time: O((E + V) log V)
# Space: O(E + V)
class Solution:
    def countPaths(self, n: int, roads: List[List[int]]) -> int:
        adjList, MOD = {}, 1000000007

        for u, v, time in roads:

            if u not in adjList:
                adjList[u] = []
            
            if v not in adjList:
                adjList[v] = []
            
            adjList[u].append([v, time])
            adjList[v].append([u, time])
        
        dist = [inf for _ in range(n)]
        ways = [0 for _ in range(n)]
        ways[0], dist[0], minHeap = 1, 0, [(0, 0)]

        while minHeap:
            time, node = heapq.heappop(minHeap)

            if node in adjList:
                for nei, tym in adjList[node]:
                    if dist[nei] > tym + time:
                        heapq.heappush(minHeap, (tym + time, nei))
                        dist[nei] = tym + time
                        ways[nei] = ways[node] % MOD
                    elif dist[nei] == tym + time:
                        ways[nei] += ways[node] % MOD
        
        return ways[n - 1] % MOD
