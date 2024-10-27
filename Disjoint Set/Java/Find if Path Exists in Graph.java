// Problem link: https://leetcode.com/problems/find-if-path-exists-in-graph/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] size = new int[n];
        int[] parent = new int[n];

        Arrays.fill(size, 1);

        for(int node = 0; node < n; node++) {
            parent[node] = node;
        }

        for(int[] edge : edges) {
            this.union(size, parent, edge[0], edge[1]);
        }

        return this.find(parent, source) == this.find(parent, destination);
    }

    private int find(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }
        parent[node] = this.find(parent, parent[node]);
        return parent[node];
    }

    private void union(int[] size, int[] parent, int nodeOne, int nodeTwo) {
        int parentOne = this.find(parent, nodeOne);
        int parentTwo = this.find(parent, nodeTwo);

        if(parentOne != parentTwo) {
            if(size[parentTwo] > size[parentOne]) {
                size[parentTwo] += size[parentOne];
                parent[parentOne] = parentTwo;
            }
            else {
                size[parentOne] += size[parentTwo];
                parent[parentTwo] = parentOne;
            }
        }
    }
}
