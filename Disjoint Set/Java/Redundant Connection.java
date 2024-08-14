// Problem link: https://leetcode.com/problems/redundant-connection/description/
// Time: O(n)
// Space: O(n)
class disjointSet {

    int[] rank;
    int[] parent;

    public disjointSet(int num) {
        this.rank = new int[num + 1];
        this.parent = new int[num + 1];

        for(int index = 0; index <= num; index++) {
            this.parent[index] = index;
        }
    }

    public int find(int node) {
        if(node == this.parent[node]) {
            return node;
        }

        this.parent[node] = this.find(this.parent[node]);
        return this.parent[node];
    }

    public void union(int nodeOne, int nodeTwo) {
        int parentOne = this.parent[nodeOne], parentTwo = this.parent[nodeTwo];

        if(parentOne == parentTwo) {
            return;
        }

        int rankOne = this.rank[parentOne], rankTwo = this.rank[parentTwo];

        if(rankOne > rankTwo) {
            this.parent[parentTwo] = parentOne;
        }
        else if(rankOne < rankTwo) {
            this.parent[parentOne] = parentTwo;
        }
        else {
            this.rank[parentOne] += 1;
            this.parent[parentTwo] = parentOne;
        }
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int result = 0;
        disjointSet DS = new disjointSet(edges.length);

        for(int index = 0; index < edges.length; index++) {
            if(DS.find(edges[index][0]) == DS.find(edges[index][1])) {
                result = index;
            }
            DS.union(edges[index][0], edges[index][1]);
        }

        return edges[result];
    }
}
