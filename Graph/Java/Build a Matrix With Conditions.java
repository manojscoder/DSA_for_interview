// Problem link: https://leetcode.com/problems/build-a-matrix-with-conditions/description/
// Time: O(k * k)
// Space: O(k * k)

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        
        int[] rowOrder = this.topoSort(rowConditions, k);
        int[] colOrder = this.topoSort(colConditions, k);

        if(rowOrder.length == 0 || colOrder.length == 0) {
            return new int[][] {};
        }

        int[][] result = new int[k][k];
        int[] rowIdx = new int[k + 1], colIdx = new int[k + 1];

        for(int idx = 0; idx < k; idx++) {
            rowIdx[rowOrder[idx]] = idx;
            colIdx[colOrder[idx]] = idx;
        }

        for(int idx = 1; idx <= k; idx++) {
            result[rowIdx[idx]][colIdx[idx]] = idx;
        }

        return result;
    }

    private int[] topoSort(int[][] edges, int num) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        int[] visited = new int[num + 1], path = new int[num + 1], result = new int[num + 1];
        result[num] = num - 1;

        for(int[] pair : edges) {
            adjList.putIfAbsent(pair[0], new ArrayList<>());
            adjList.get(pair[0]).add(pair[1]);
        }

        for(int idx = 1; idx <= num; idx++) {
            if(this.dfs(adjList, visited, path, result, idx)) {
                return new int[] {};
            }
        }

        return result;
    }

    private boolean dfs(Map<Integer, List<Integer>> adjList, int[] visited, int[] path, int[] result, int node) {
        if(path[node] == 1) {
            return true;
        }
        else if(visited[node] == 1) {
            return false;
        }

        path[node] = visited[node] = 1;

        if(adjList.containsKey(node)) {
            for(int ver : adjList.get(node)) {
                if(this.dfs(adjList, visited, path, result, ver)) {
                    return true;
                }
            }
        }

        path[node] = 0;
        result[result[result.length - 1]--] = node;

        return false;
    }
}
