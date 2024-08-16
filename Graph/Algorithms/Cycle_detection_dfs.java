// Time: O(V + E)
// Space: O(V)
public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visit = new int[V];
        int[] cycle = new int[V];
		
		for(int node = 0; node < V; node++) {
		    if(visit[node] != 1) {
		        if(dfs(node, visit, adj, -1)) 
		            return true;
		    }
		}
		
		return false;
    }
    
    private boolean dfs(int node, int[] visit, ArrayList<ArrayList<Integer>> adj, int parent) {
        visit[node] = 1;
        
        for(int nei : adj.get(node)) {
            if(visit[nei] != 1) {
                if(dfs(nei, visit, adj, node)) {
		            return true;
                }
            }
            else if(nei != parent) {
                return true;
            }
        }
        
        return false;
    }
