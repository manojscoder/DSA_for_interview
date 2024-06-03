# Problem link: https://leetcode.com/problems/all-paths-from-source-to-target/description/
# Time: O(2 ^ V * V)
# Space: O(2 ^ V * V)
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        result, stack = [], [(0, [0])]

        while stack:
            node, path = stack.pop()

            if node == len(graph) - 1:
                result.append(path.copy())
            else:
                for v in graph[node]:
                    stack.append((v, path + [v]))
        
        return result
