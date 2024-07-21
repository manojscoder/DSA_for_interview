# Kahn's algorithm BFS topo
# Time: O(n)
# Space: O(n)

from collections import deque

def topoSort(edges, totalNodes):
    indegree, topoOrder = [0] * totalNodes, []
    adjList = [[] for _ in range(totalNodes + 1)]
    
    for u, v in edges:
        adjList[u].append(v)
        indegree[v] += 1
    
    queue, visit = deque(), set()
    
    for idx in range(len(indegree)):
        if indegree[idx] == 0:
            queue.append(idx)
    
    while queue:
        node = queue.popleft()
        topoOrder.append(node)
        
        for ver in adjList[node]:
            indegree[ver] -= 1
            if indegree[ver] == 0:
                queue.append(ver)
    
    return topoOrder


edges = [[5, 0], [4, 0], [4, 1], [3, 1], [2, 3], [5, 2]]
totalNodes = 6

topoOrder = topoSort(edges, totalNodes)

if len(topoOrder) != totalNodes:
    print("Cycle exist")
else:
    print(topoOrder)
