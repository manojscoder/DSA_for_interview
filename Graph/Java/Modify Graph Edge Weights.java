// Problem link: https://leetcode.com/problems/modify-graph-edge-weights/description
// Time: O(K * (V + E) * log V)
// Space: O(V + E)
class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] adjList = new ArrayList[n];

        for(int node = 0; node < n; node++) {
            adjList[node] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            if(edge[2] != -1) {
                adjList[edge[0]].add(new int[] {edge[1], edge[2]});
                adjList[edge[1]].add(new int[] {edge[0], edge[2]});
            }
        }

        int shortDist = this.dijkstra(adjList, source, destination, n), dist;

        if(shortDist == target) {
            for(int idx = 0; idx < edges.length; idx++) {
                if(edges[idx][2] == -1) {
                    edges[idx][2] = target;
                }
            }
            return edges;
        }
        else if(shortDist > target) {
            for(int idx = 0; idx < edges.length; idx++) {
                if(edges[idx][2] == -1) {
                    edges[idx][2] = 1;
                    adjList[edges[idx][0]].add(new int[] { edges[idx][1], 1});
                    adjList[edges[idx][1]].add(new int[] { edges[idx][0], 1});
                    dist = this.dijkstra(adjList, source, destination, n);

                    if(dist <= target) {
                        edges[idx][2] += target - dist;
                        for(int i = idx + 1; i < edges.length; i++) {
                            if(edges[i][2] == -1) {
                                edges[i][2] = target;
                            }
                        }
                        return edges;
                    }
                }
            }
        }

        return new int[][] {};
    }

    private int dijkstra(List<int[]>[] adjList, int src, int des, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.offer(new int[] {0, src});
        dist[src] = 0;

        while(!minHeap.isEmpty()) {
            int[] node = minHeap.poll();

            for(int[] nei : adjList[node[1]]) {
                if(node[0] + nei[1] < dist[nei[0]]) {
                    dist[nei[0]] = node[0] + nei[1];
                    minHeap.offer(new int[] {dist[nei[0]], nei[0]});
                }
            }
        }

        return dist[des];
    }
}
