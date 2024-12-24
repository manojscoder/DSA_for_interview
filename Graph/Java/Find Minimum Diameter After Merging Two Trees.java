// Problem link: https://leetcode.com/problems/find-minimum-diameter-after-merging-two-trees/description/
// Time: O(n + m)
// Space: O(n + m)
class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<Integer>[] adjListOne = this.buildAdjList(edges1);
        List<Integer>[] adjListTwo = this.buildAdjList(edges2);

        int diameterOne = this.maxDiameter(-1, 0, adjListOne)[0];
        int diameterTwo = this.maxDiameter(-1, 0, adjListTwo)[0];
        int addGraph = (int)Math.ceil(diameterOne / 2.0) + (int)Math.ceil(diameterTwo / 2.0) + 1;

        return Math.max(addGraph, Math.max(diameterOne, diameterTwo));
    }

    private List<Integer>[] buildAdjList(int[][] edges) {
        int size = edges.length + 1;
        List<Integer>[] adjList = new ArrayList[size];

        for(int index = 0; index < size; index++) {
            adjList[index] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        return adjList;
    }

    private int[] maxDiameter(int parent, int node, List<Integer>[] adjList) {
        int first = 0, second = 0, maxDia = 0, store[];

        for(int nei : adjList[node]) {
            if(nei != parent) {
                store = this.maxDiameter(node, nei, adjList);
                maxDia = Math.max(maxDia, store[0]);

                if(store[1] > first) {
                    second = first;
                    first = store[1];
                }
                else if(store[1] > second) {
                    second = store[1];
                }
            }
        }

        maxDia = Math.max(maxDia, first + second);
        return new int[] {maxDia, first + 1};
    }
}
