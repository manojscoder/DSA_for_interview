// Problem link: https://leetcode.com/problems/longest-cycle-in-a-graph/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int longestCycle(int[] edges) {
        int[] visit = new int[edges.length];
        int result = -1;

        for(int node = 0; node < edges.length; node++) {
            if(visit[node] == 0) {
                result = Math.max(result, this.dfs(node, edges, visit, 1, -1));
            }
        }

        return result;
    }

    private int dfs(int node, int[] edges, int[] visit, int dist, int maxDist) {
        if(visit[node] != 0) {
            return visit[node] > 0 ? dist - visit[node] : -1;
        }

        visit[node] = dist;

        if(edges[node] != -1) {
            maxDist = Math.max(maxDist, this.dfs(edges[node], edges, visit, dist + 1, maxDist));
        }

        visit[node] = -1;
        return maxDist;
    }
}
