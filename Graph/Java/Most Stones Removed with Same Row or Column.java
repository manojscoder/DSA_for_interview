// Problem link: https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public int removeStones(int[][] stones) {
        int num = stones.length, result = 0;
        int[] visit = new int[num];

        for(int node = 0; node < num; node++) {
            if(visit[node] == 0) {
                this.dfs(node, num, stones, visit);
                result += 1;
            }
        }

        return num - result;
    }

    private void dfs(int node, int num, int[][] stones, int[] visit) {
        visit[node] = 1;

        for(int nei = 0; nei < num; nei++) {
            if(visit[nei] == 0) {
                if(stones[node][0] == stones[nei][0]) {
                    this.dfs(nei, num, stones, visit);
                }
                if(stones[node][1] == stones[nei][1]) {
                    this.dfs(nei, num, stones, visit);
                }
            }
        }
    }
}
