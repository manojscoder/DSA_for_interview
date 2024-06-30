// Problem link: https://leetcode.com/problems/redundant-connection/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] rank = new int[edges.length + 1];
        int[] parent = new int[edges.length + 1];
        int result = 0;

        for(int i = 0; i < edges.length + 1; i++) {
            rank[i] = 1;
            parent[i] = i;
        }

        for(int i = 0; i < edges.length; i++) {
            if(!this.union(edges[i][0], edges[i][1], rank, parent)) {
                result = i;
            }
        }

        return edges[result];
    }

    private int find(int[] parent, int node) {
        node = parent[node];
        while(node != parent[node]) {
            parent[node] = parent[parent[node]];
            node = parent[node];
        }

        return node;
    }

    private boolean union(int node_1, int node_2, int[] rank, int[] parent) {
        int p1 = this.find(parent, node_1), p2 = this.find(parent, node_2);

        if(p1 == p2)
            return false;
        
        if(rank[p1] > rank[p2]) {
            rank[p1] += rank[p2];
            parent[p2] = p1;
        }
        else {
            rank[p2] += rank[p1];
            parent[p1] = p2;
        }

        return true;
    }
}
