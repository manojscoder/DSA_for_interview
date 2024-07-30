// Problem link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
// Time: O(E * K)
// Space: O(n)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        int[] tempCost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for(int stop = 0; stop < k + 1; stop++) {
            for(int index = 0; index < n; index++) {
                tempCost[index] = cost[index];
            }

            for(int[] path : flights) {
                if(cost[path[0]] != Integer.MAX_VALUE && cost[path[0]] + path[2] < tempCost[path[1]]) {
                    tempCost[path[1]] = cost[path[0]] + path[2];
                }
            }

            for(int index = 0; index < n; index++) {
                cost[index] = tempCost[index];
            }
        }

        return cost[dst] != Integer.MAX_VALUE ? cost[dst] : -1;
    }
}
