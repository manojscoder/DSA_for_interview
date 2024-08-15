# Time: O(V + E)
# Space: O(V + E)
def dfs(node, visit, adjList, store):
    visit[node] = 1
    
    for nei in adjList[node]:
        if not visit[nei]:
            dfs(nei, visit, adjList, store)
    
    store.append(node)
  
def kosaraju(edges, num):
    adjList = [[] for _ in range(num)]
    reversedEdges = [[] for _ in range(num)]
    
    for u, v in edges:
        adjList[u].append(v)
    
    visit, stack = [0] * num, []
    
    for node in range(num):
        if not visit[node]:
            dfs(node, visit, adjList, stack)
            
    
    for u, v in edges:
        reversedEdges[v].append(u)
    
    result, visit = [], [0] * num
    
    for node in stack[::-1]:
        if not visit[node]:
            curr = []
            dfs(node, visit, reversedEdges, curr)
            result.append(curr)
        
    return result
