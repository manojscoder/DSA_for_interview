// Time: O(4 alpha)
public class DisjointSetSize {
    int[] size;
    int[] ultimateParent;

    public DisjointSetSize(int num) {
        this.size = new int[num + 1];
        this.ultimateParent = new int[num + 1];

        Arrays.fill(size, 1);
        for(int index = 0; index <= num; index++) {
            this.ultimateParent[index] = index;
        }
    }

    private int findParent(int node) {
        if(this.ultimateParent[node] == node) {
            return node;
        }

        this.ultimateParent[node] = this.findParent(this.ultimateParent[node]);
        return this.ultimateParent[node];
    }

    private void unionBySize(int nodeOne, int nodeTwo) {
        int parentOne = this.findParent(nodeOne), parentTwo = this.findParent(nodeTwo);
        if(parentOne == parentTwo) {
            return;
        }
        int sizeOne = this.size[parentOne], sizeTwo = this.size[parentTwo];

        if(sizeOne < sizeTwo) {
            this.size[parentTwo] += sizeOne;
            this.ultimateParent[parentOne] = parentTwo;
        }
        else {
            this.size[parentOne] += sizeTwo;
            this.ultimateParent[parentTwo] = parentOne;
        }
    }

    public static void main(String[] args) {
        DisjointSetSize ds = new DisjointSetSize(7);
        int[][] edges = {{1, 2}, {2, 3}, {4, 5}, {6, 7}, {5, 6}, {3, 7}};

        for(int index = 0; index < edges.length - 1; index++) {
            ds.unionBySize(edges[index][0], edges[index][1]);
        }

        // Testing
        if(ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Both are in same component");
        }
        else {
            System.out.println("Both are not in same component");
        }

        ds.unionBySize(3, 7);

        if(ds.findParent(3) == ds.findParent(7)) {
            System.out.println("Both are in same component");
        }
        else {
            System.out.println("Both are not in same component");
        }

    }
}
