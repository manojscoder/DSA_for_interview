// Problem link: https://leetcode.com/problems/loud-and-rich/description/
// Time: O(n ^ 2)
// Space: O(n)
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int numNodes = quiet.length, node;
        List<Integer>[] adjList = new ArrayList[numNodes];
        int[] result = new int[numNodes], indegree = new int[numNodes];
        Queue<Integer> queue = new LinkedList<>();

        for(node = 0; node < numNodes; node++) {
            adjList[node] = new ArrayList<>();
        }

        for(int[] edge : richer) {
            adjList[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }

        for(node = 0; node < numNodes; node++) {
            result[node] = node;
            if(indegree[node] == 0) {
                queue.offer(node);
            }
        }

        while(!queue.isEmpty()) {
            node = queue.poll();

            for(int nei : adjList[node]) {
                if(quiet[result[nei]] > quiet[result[node]]) {
                    result[nei] = result[node];
                }

                indegree[nei]--;

                if(indegree[nei] == 0) {
                    queue.offer(nei);
                }
            } 
        }

        return result;
    }
}
