// Problem link: https://leetcode.com/problems/maximum-number-of-k-divisible-components/description
// Time: O(n + m)
// Space: O(n + m)
class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<Integer>[] adjList = new ArrayList[n];
        int[] result = new int[1];

        for(int index = 0; index < n; index++) {
            adjList[index] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        this.dfs(-1, 0, adjList, result, values, k);

        return result[0];
    }

    private int dfs(int par, int node, List<Integer>[] adjList, int[] result, int[] values, int k) {
        int total = values[node];

        for(int nei : adjList[node]) {
            if(nei != par) {
                total += this.dfs(node, nei, adjList, result, values, k) % k;
            }
        }

        if(total % k == 0) {
            result[0]++;
        }

        return total;
    }
}
