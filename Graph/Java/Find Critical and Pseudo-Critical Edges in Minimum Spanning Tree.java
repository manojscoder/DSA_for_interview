// Problem link: https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/description/
// Time: O(e ^ 2 * log(v))
// Space: O(e * v)
class UnionFind {

    int[] parent, size;

    public UnionFind(int num) {
        this.parent = new int[num];
        this.size = new int[num];

        for(int node = 0; node < num; node++) {
            this.parent[node] = node;
            this.size[node] = 1;
        }
    }

    public int find(int node) {
        if(this.parent[node] == node) {
            return node;
        }
        this.parent[node] = this.find(parent[node]);
        return this.parent[node];
    }

    public void union(int nodeOne, int nodeTwo) {
        int parentOne = this.find(nodeOne), parentTwo = this.find(nodeTwo);

        if(parentOne != parentTwo) {
            if(this.size[parentOne] < this.size[parentTwo]) {
                this.size[parentTwo] += this.size[parentOne];
                this.parent[parentOne] = parentTwo;
            }
            else {
                this.size[parentOne] += this.size[parentTwo];
                this.parent[parentTwo] = parentOne;
            }
        }
    }
}


class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int size = edges.length, mstWeight = 0, CWeight, PCWeight;
        UnionFind unionFind = new UnionFind(n), CriticalUF, PseudoUF;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> critical = new ArrayList<>(), pseudo = new ArrayList<>();

        for(int index = 0; index < size; index++) {
            edges[index] = new int[] {edges[index][0], edges[index][1], edges[index][2], index};
        }

        Arrays.sort(edges, (a, b) -> Integer.compare(a[2], b[2]));

        for(int[] edge : edges) {
            if(unionFind.find(edge[0]) != unionFind.find(edge[1])) {
                unionFind.union(edge[0], edge[1]);
                mstWeight += edge[2];
            }
        }

        for(int[] edge : edges) {
            CWeight = 0;
            CriticalUF = new UnionFind(n);

            for(int index = 0; index < size; index++) {
                if(edges[index][3] != edge[3] && CriticalUF.find(edges[index][0]) != CriticalUF.find(edges[index][1])) {
                    CriticalUF.union(edges[index][0], edges[index][1]);
                    CWeight += edges[index][2];
                }
            }

            if(CWeight != mstWeight) {
                critical.add(edge[3]);
            }
            else {
                PCWeight = edge[2];
                PseudoUF = new UnionFind(n);
                PseudoUF.union(edge[0], edge[1]);

                for(int index = 0; index < size; index++) {
                    if(PseudoUF.find(edges[index][0]) != PseudoUF.find(edges[index][1])) {
                        PseudoUF.union(edges[index][0], edges[index][1]);
                        PCWeight += edges[index][2];
                    }
                }

                if(PCWeight == mstWeight) {
                    pseudo.add(edge[3]);
                }
            }
        }

        result.add(critical);
        result.add(pseudo);

        return result;
    }
}
