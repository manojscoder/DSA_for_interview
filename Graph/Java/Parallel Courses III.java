// Problem link: https://leetcode.com/problems/parallel-courses-iii/description/
// Time: O(n + e)
// Space: O(n + e)
class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        int[] indegree = new int[n], track = new int[n];
        List<Integer>[] adjList = new ArrayList[n];
        Queue<Integer> queue = new LinkedList<>();
        int result = 0, node;

        for(node = 0; node < n; node++) {
            adjList[node] = new ArrayList<>();
        }

        for(int[] edge : relations) {
            adjList[edge[0] - 1].add(edge[1] - 1);
            indegree[edge[1] - 1]++;
        }

        for(node = 0; node < n; node++) {
            if(indegree[node] == 0) {
                queue.offer(node);
            }
            track[node] = time[node];
        }

        while(!queue.isEmpty()) {
            node = queue.poll();

            for(int nei : adjList[node]) {
                track[nei] = Math.max(track[nei], track[node] + time[nei]);
                indegree[nei]--;

                if(indegree[nei] == 0) {
                    queue.offer(nei);
                }
            }
            result = Math.max(result, track[node]);
        }

        return result;
    }
}
