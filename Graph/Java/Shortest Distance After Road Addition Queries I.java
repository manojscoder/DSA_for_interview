// Problem link: https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description
// Time: O(V + E log V)
// Space: O(V + E + q)
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int size = queries.length;
        int[] result = new int[size];

        List<Integer>[] adjList = new ArrayList[n];

        for(int idx = 0; idx < n; idx++) {
            adjList[idx] = new ArrayList<>();
            adjList[idx].add(idx + 1);
        }

        for(int idx = 0; idx < size; idx++) {
            adjList[queries[idx][0]].add(queries[idx][1]);
            result[idx] = this.BFS(adjList, 0, n - 1);
        }

        return result;
    }

    private int BFS(List<Integer>[] adjList, int src, int des) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[des + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;
        queue.offer(src);

        while(!queue.isEmpty()) {
            int node = queue.poll();

            if(node == des) {
                return distance[node];
            }

            for(int nei : adjList[node]) {
                if(distance[node] + 1 < distance[nei]) {
                    distance[nei] = distance[node] + 1;
                    queue.offer(nei);
                }
            }
        }

        return distance[des];
    }
}
