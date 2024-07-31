// Problem link: https://leetcode.com/problems/number-of-restricted-paths-from-first-to-last-node/description/
// Time: O((E + V) log V)
// Space: O(V + E)

class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
        List<int[]>[] adjList = new ArrayList[n + 1];
        int[] dp = new int[n + 1];

        for(int idx = 1; idx < n + 1; idx++) {
            adjList[idx] = new ArrayList<>(); 
        }

        for(int[] trip : edges) {
            adjList[trip[0]].add(new int[] {trip[1], trip[2]});
            adjList[trip[1]].add(new int[] {trip[0], trip[2]});
        }

        int[] minDistance = this.dijkstra(adjList, n);
        Arrays.fill(dp, -1);


        return this.dfs(adjList, minDistance, Integer.MAX_VALUE, 1, dp);
    }

    private int dfs(List<int[]>[] adjList, int[] minDistance, int prev, int node, int[] dp) {
        if(node == adjList.length - 1) {
            return 1;
        }
        else if(prev <= minDistance[node]) {
            return 0;
        }
        else if(dp[node] != -1) {
            return dp[node];
        }

        dp[node] = 0;

        for(int[] pair : adjList[node]) {
            dp[node] = (dp[node] + this.dfs(adjList, minDistance, minDistance[node], pair[0], dp)) % (int)(1e9 + 7);
        }

        return dp[node];
    }

    private int[] dijkstra(List<int[]>[] adjList, int size) {
        int[] distance = new int[size + 1];
        int[] visited = new int[size + 1], pair;
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        distance[size] = 0;
        heap.offer(new int[] {0, size});

        while(!heap.isEmpty()) {
            pair = heap.poll();

            if(visited[pair[1]] == 1) {
                continue;
            }

            visited[pair[1]] = 1;

            for(int[] nei : adjList[pair[1]]) {
                if(nei[1] + pair[0] < distance[nei[0]]) {
                    distance[nei[0]] = nei[1] + pair[0];
                    heap.offer(new int[] {distance[nei[0]], nei[0]});
                }
            }
        }

        return distance;
    }
}
