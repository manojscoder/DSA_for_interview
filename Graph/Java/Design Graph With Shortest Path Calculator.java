// Problem link: https://leetcode.com/problems/design-graph-with-shortest-path-calculator/
// Time: O(V + E * log V)
// Space: O(V + E)
class Graph {
    Map<Integer, List<int[]>> adjList;
    int numV;

    public Graph(int n, int[][] edges) {
        this.adjList = new HashMap<>();
        this.numV = n;
        for(int i = 0; i < edges.length; i++) {
            adjList.putIfAbsent(edges[i][0], new ArrayList<>());
            adjList.get(edges[i][0]).add(new int[] {edges[i][1], edges[i][2]});
        }
    }
    
    public void addEdge(int[] edge) {
        adjList.putIfAbsent(edge[0], new ArrayList<>());
        adjList.get(edge[0]).add(new int[] {edge[1], edge[2]});
    }
    
    public int shortestPath(int src, int des) {
        int[] dist = new int[this.numV], details;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[] visited = new boolean[this.numV + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        minHeap.offer(new int[] {0, src});

        while(!minHeap.isEmpty()) {
            details = minHeap.poll();
            if(visited[details[1]])
                continue;
            
            if(details[1] == des)
                return details[0];

            visited[details[1]] = true;

            if(this.adjList.containsKey(details[1])) {
                for(int[] store : adjList.get(details[1])) {
                    if(dist[store[0]] > details[0] + store[1]) {
                        dist[store[0]] = details[0] + store[1];
                        minHeap.offer(new int[] {dist[store[0]], store[0]});
                    }
                }
            }
        }

        return -1;         
    }
}
