# Problem link: https://leetcode.com/problems/second-minimum-time-to-reach-destination/description
# Time: O(n + e)
# Space: O(n)
class Solution:
    def secondMinimum(self, n: int, edges: List[List[int]], time: int, change: int) -> int:
        adjList = [[] for _ in range(n + 1)]

        for u, v in edges:
            adjList[u].append(v)
            adjList[v].append(u)
        
        queue, prev = deque([1]), 0
        visited = [[] for _ in range(n + 1)]
        curr = 0

        while queue:
            for _ in range(len(queue)):
                node = queue.popleft()

                if node == n:
                    if prev:
                        return curr
                    prev = 1

                for nei in adjList[node]:
                    if len(visited[nei]) == 0 or (len(visited[nei]) == 1 and visited[nei][0] != curr):
                        queue.append(nei)
                        visited[nei].append(curr)
                
            if (curr // change) % 2:
                curr += (change - curr % change)
            curr += time
        
        return curr
