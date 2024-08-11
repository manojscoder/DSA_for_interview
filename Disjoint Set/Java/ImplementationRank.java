// Time: O(4 alpha)
public class DisjointSet {
    int[] rank;
    int[] ultimateParent;

    public DisjointSet(int num) {
        this.rank = new int[num + 1];
        this.ultimateParent = new int[num + 1];
        for(int index = 0; index <= num; index++) {
            this.ultimateParent[index] = index;
        }
    }

    private int findParent(int node) {
        if(node == this.ultimateParent[node]) {
            return node;
        }
        this.ultimateParent[node] = this.findParent(this.ultimateParent[node]);
        return this.ultimateParent[node];
    }

    private void unionByRank(int nodeOne, int nodeTwo) {
        int parentOne = this.findParent(nodeOne), parentTwo = this.findParent(nodeTwo);

        if(parentTwo == parentOne) {
            return;
        }

        int rankOne = this.rank[parentOne], rankTwo = this.rank[parentTwo];
        if(rankOne < rankTwo) {
            this.ultimateParent[parentOne] = parentTwo;
        }
        else if(rankOne > rankTwo) {
            this.ultimateParent[parentTwo] = parentOne;
        }
        else {
            this.ultimateParent[parentTwo] = parentOne;
            this.rank[parentOne] = rankOne + 1;
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        int[][] edges = {{1, 2}, {2, 3}, {4, 5}, {6, 7}, {5, 6}, {3, 7}};

        for(int index = 0; index < edges.length - 1; index++) {
            ds.unionByRank(edges[index][0], edges[index][1]);
        }
        
        // Testing
        if(ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Both are in same component");
        }
        else {
            System.out.println("Both are not in same component");
        }

        ds.unionByRank(3, 7);

        if(ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Both are in same component");
        }
        else {
            System.out.println("Both are not in same component");
        }

    }
}
