// Problem link: https://leetcode.com/problems/the-time-when-the-network-becomes-idle/description/
// Time: O(n + m)
// Space: O(n + m)
class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int result = 0, size = patience.length, remainder;
        List<Integer>[] adjList = new ArrayList[size];

        for(int idx = 0; idx < size; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        int[] distance = new int[size];
        int[] visited = new int[size];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {0, 0});
        visited[0] = 1;

        while(!queue.isEmpty()) {
            int[] pair = queue.poll();

            distance[pair[0]] = pair[1] * 2;

            for(int nei : adjList[pair[0]]) {
                if(visited[nei] == 0) {
                    queue.offer(new int[] {nei, pair[1] + 1});
                    visited[nei] = 1;
                }
            }
        }

        for(int idx = 1; idx < size; idx++) {
            if(distance[idx] <= patience[idx]) {
                result = Math.max(result, distance[idx]);
            }
            else {
                remainder = distance[idx] % patience[idx];
                result = Math.max(result, distance[idx] + distance[idx] - (remainder > 0 ? remainder : patience[idx]));
            }
        }

        return result + 1;
    }
}
