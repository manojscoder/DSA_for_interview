# Problem link: https://leetcode.com/problems/loud-and-rich/description/
# Time: O(n ^ 2)
# Space: O(n)
class Solution:
    def loudAndRich(self, richer: List[List[int]], quiet: List[int]) -> List[int]:
        numNodes = len(quiet)
        result, indegree = [node for node in range(numNodes)], [0] * numNodes
        adjList = [[] for _ in range(numNodes)]

        for u, v in richer:
            adjList[u].append(v)
            indegree[v] += 1
        
        queue = deque([node for node in range(numNodes) if indegree[node] == 0])

        while queue:
            node = queue.popleft()

            for nei in adjList[node]:
                if quiet[result[node]] < quiet[result[nei]]:
                    result[nei] = result[node]
                indegree[nei] -= 1

                if indegree[nei] == 0:
                    queue.append(nei)

        return result
