// Time: O(E log E)
// Space: O(E)
class DS {
    int[] rank, parent;

    public DS(int num) {
        this.rank = new int[num + 1];
        this.parent = new int[num + 1];

        for(int idx = 0; idx <= num; idx++) {
            this.parent[idx] = idx;
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
        int parentOne = this.find(nodeOne), parentTwo = this.find(nodeTwo);

        if(parentOne != parentTwo) {
            if(this.rank[parentOne] > this.rank[parentTwo]) {
                this.parent[parentTwo] = parentOne;
            }
            else if(this.rank[parentOne] < this.rank[parentTwo]) {
                this.parent[parentOne] = parentTwo;
            }
            else {
                this.rank[parentTwo] += 1;
                this.parent[parentTwo] = parentOne;
            }
        }
    }
}

public class Kruskals {

    private static void mst(int[][] edges, int num) {
        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));
        DS store = new DS(num);
        List<int[]> mstEdges = new ArrayList<>();
        int cost = 0;

        for(int[] edge : edges) {
            if(store.find(edge[0]) != store.find(edge[1])) {
                store.union(edge[0], edge[1]);
                mstEdges.add(new int[] {edge[0], edge[1]});
                cost += edge[2];
            }
        }

        System.out.println(cost);

        for(int[] edge : mstEdges) {
            System.out.println(Arrays.toString(edge));
        }
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 4, 2}, {3, 2, 2}, {4, 3, 1}};
        mst(edges, 5);
    }
}
