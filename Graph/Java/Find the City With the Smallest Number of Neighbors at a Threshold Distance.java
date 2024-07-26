// Problem link: https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description
// Algorithm: Floyd algorithm
// Time: O(n ^ 3)
// Space: O(n ^ 2)
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjMatrix = new int[n][n];
        int count = Integer.MAX_VALUE, result = 0, value;

        for(int[] row : adjMatrix) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int[] triplet : edges) {
            adjMatrix[triplet[0]][triplet[1]] = triplet[2];
            adjMatrix[triplet[1]][triplet[0]] = triplet[2];
        }

        this.floyd(adjMatrix, n);

        for(int i = 0; i < n; i++) {
                value = 0;

                for(int j = 0; j < n; j++) {
                    if(i != j && adjMatrix[i][j] <= distanceThreshold) {
                        value++;
                    }
                }
                
                if(value <= count) {
                    result = i;
                    count = value;
                }
        }

        return result;
    }

    private void floyd(int[][] adjMatrix, int n) {
        for(int k = 0; k < n; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(adjMatrix[i][k] != Integer.MAX_VALUE && adjMatrix[k][j] != Integer.MAX_VALUE) {
                        adjMatrix[i][j] = Math.min(adjMatrix[i][j], adjMatrix[i][k] + adjMatrix[k][j]);
                    }
                }
            }
        }
    }
}
