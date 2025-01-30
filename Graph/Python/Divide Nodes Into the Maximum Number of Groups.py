# Problem link: https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/
# Time: O(n * (n + m))
# Space: O(n)
class Solution:
    def magnificentSets(self, n: int, edges: List[List[int]]) -> int:
        adjList, result, visited = [[] for _ in range(n + 1)], 0, [False] * (n + 1)

        for u, v in edges:
            adjList[u].append(v)
            adjList[v].append(u)
        
        def check(start):
            distance, nodes, track = [0] * (n + 1), [start], 1
            queue, distance[start] = deque([(start, 1)]), 1

            while queue:
                node, length = queue.popleft()

                for nei in adjList[node]:
                    if distance[nei]:
                        if distance[nei] == length:
                            return None, -1
                    else:
                        queue.append((nei, length + 1))
                        distance[nei] = track = length + 1
                        nodes.append(nei)
                        visited[nei] = True
            
            return nodes, track
        

        for node in range(1, n + 1):
            if not visited[node]:
                nodes, length = check(node)
                maxLength, visited[node] = 0, True

                if length == -1:
                    return -1
                
                for src in nodes:
                    _, length = check(src)
                    maxLength = max(maxLength, length)
                
                result += maxLength
        
        return result
