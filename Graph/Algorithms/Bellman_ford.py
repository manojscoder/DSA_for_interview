# Time: O(V * E)
# Space: O(V)
def Bellman_ford(edges, n, src):
    dist = [float('inf') for _ in range(n)]
    dist[src] = 0
        
    for i in range(n):
        for j in range(len(edges)):
            if dist[edges[j][0]] != float('inf') and dist[edges[j][0]] + edges[j][2] < dist[edges[j][1]]:
                if i == n - 1:
                    print("Negative cycle exist")
                    return [-1]
                dist[edges[j][1]] = dist[edges[j][0]] + edges[j][2]
        
    return dist
