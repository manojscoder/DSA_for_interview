# Time: O(E log E)
# Space: O(E)
def prims(edges, num):
    adjList = [[] for _ in range(num)]
    visit = [0] * num
    
    for u, v, w in edges:
        adjList[u].append([v, w])
        adjList[v].append([u, w])
    
    minHeap = [(0, 0, -1)]
    mstEdges, cost = [], 0
    
    while minHeap:
        weight, node, nxt = heapq.heappop(minHeap)
        
        if visit[node]:
            continue
        
        if nxt != -1:
            mstEdges.append([node, nxt])
        
        visit[node], cost = 1, cost + weight
        
        for nei, wt in adjList[node]:
            heapq.heappush(minHeap, (wt, nei, node))
    
    print(cost)
    print(mstEdges)
