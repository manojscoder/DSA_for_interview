// Problem link: https://leetcode.com/problems/find-champion-ii/description
// Time: O(V + E)
// Space: O(V)
class Solution {
    public int findChampion(int n, int[][] edges) {
        int[] indegree = new int[n];
        int result = -1;

        for(int[] edge : edges) {
            indegree[edge[1]]++;
        }
        

        for(int index = 0; index < n; index++) {
            if(indegree[index] == 0) {
                if(result != -1) {
                    return -1;
                }
                result = index;
            }
        }

        return result;
    }
}
