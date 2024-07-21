# Topological sort DFS
# Time: O(n)
# Space: O(n)

def dfs(adjList, path, visited, result, node):
    if path[node]:
        return True
    elif visited[node]:
        return False
        
    path[node] = visited[node] = 1

    for ver in adjList[node]:
        if dfs(adjList, path, visited, result, ver):
            return True

    path[node] = 0
    result.append(node)

    return False


def topoSort(edges, num):
    adjList = [[] for _ in range(num + 1)]

    for u, v in edges:
        adjList[u].append(v)
     
    path, visited, result = [0] * (num + 1), [0] * (num + 1), []

    for idx in range(1, num + 1):
        if dfs(adjList, path, visited, result, idx):
            return []
        
    return result[::-1]


edges = [[1, 2], [3, 2]]
totalNodes = 3

topoOrder = topoSort(edges, totalNodes)

if not topoOrder:
    print("Cycle exist")
else:
    print(topoOrder)
