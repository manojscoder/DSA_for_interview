// Time: O(V + E)
// Space: O(V)
public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visit = new int[V];
        
        for(int node = 0; node < V; node++) {
            if(visit[node] != 1) {
                if(bfs(node, -1, visit, adj)) {
                    return true;
                }
            }
        }
        
        return false;
        
        
    }
    
    private boolean bfs(int node, int parent, int[] visit, ArrayList<ArrayList<Integer>> adj) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {node, parent});
        
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            
            visit[pair[0]] = 1;
            
            for(int nei : adj.get(pair[0])) {
                if(visit[nei] != 1) {
                    queue.offer(new int[] {nei, pair[0]});
                }
                else if(nei != pair[1]) {
                    return true;
                }
            }
        }
        
		return false;
    }
