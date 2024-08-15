// Problem link: https://leetcode.com/problems/number-of-operations-to-make-network-connected/
// Tinme: O(V + E)
// Space: O(V + E)
class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) {
            return -1;
        }

        int[] size = new int[n];
        int[] parent = new int[n];
        Set<Integer> result = new HashSet<>();

        for(int node = 0; node < n; node++) {
            size[node] = 1;
            parent[node] = node;
        }

        for(int[] edge : connections) {
            if(this.find(parent, edge[0]) != this.find(parent, edge[1])) {
                this.union(parent, size, edge[0], edge[1]);
            }
        }

        for(int node = 0; node < n; node++) {
            result.add(this.find(parent, node));
        }

        return result.size() - 1;
    }

    private int find(int[] parent, int node) {
        if(node == parent[node]) {
            return node;
        }
        parent[node] = this.find(parent, parent[node]);
        return parent[node];
    }

    private void union(int[] parent, int[] size, int nodeOne, int nodeTwo) {
        int parentOne = this.find(parent, nodeOne), parentTwo = this.find(parent, nodeTwo);

        if(parentOne != parentTwo) {
            if(size[parentTwo] > size[parentTwo]) {
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
