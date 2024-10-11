// Problem link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adjList = new ArrayList[n + 1];
        boolean[] visit = new boolean[n + 1];

        for(int idx = 0; idx < n + 1; idx++) {
            adjList[idx] = new ArrayList<>();
        }

        for(int[] road : roads) {
            adjList[road[0]].add(new int[] {road[1], road[2]});
            adjList[road[1]].add(new int[] {road[0], road[2]});
        }

        return this.dfs(1, adjList, visit, Integer.MAX_VALUE);
    }

    private int dfs(int node, List<int[]>[] adjList, boolean[] visit, int score) {
        visit[node] = true;

        for(int[] pair : adjList[node]) {
            if(!visit[pair[0]]) {
                score = Math.min(score, Math.min(pair[1], this.dfs(pair[0], adjList, visit, score)));
            }
            else {
                score = Math.min(score, pair[1]);
            }
        }

        return score;
    }
}
