// Problem link: https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/description/
// Time: O(n)
// Space: O(n)
class Solution {
    public int minScore(int n, int[][] roads) {
        int[] parent = new int[n + 1], size = new int[n + 1];
        int result = Integer.MAX_VALUE;

        Arrays.fill(size, 1);

        for(int node = 1; node <= n; node++) {
            parent[node] = node;
        }

        for(int[] road : roads) {
            this.union(parent, size, road[0], road[1]);
        }

        for(int[] road : roads) {
            if(this.find(parent, road[0]) == this.find(parent, 1)) {
                result = Math.min(result, road[2]);
            }
        }

        return result;
    }

    private int find(int[] parent, int node) {
        if(node == parent[node]) {
            return node;
        }
        parent[node] = this.find(parent, parent[node]);
        return parent[node];
    }

    private void union(int[] parent, int[] size, int nodeOne, int nodeTwo) {
        int parOne = this.find(parent, nodeOne), parTwo = this.find(parent, nodeTwo);

        if(parOne != parTwo) {
            if(size[parOne] < size[parTwo]) {
                parent[parOne] = parTwo;
                size[parTwo] += size[parOne];
            }
            else {
                parent[parTwo] = parOne;
                size[parOne] += size[parTwo];
            }
        }
    }
}
