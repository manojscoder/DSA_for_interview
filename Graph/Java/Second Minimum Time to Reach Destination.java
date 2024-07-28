// problem link: https://leetcode.com/problems/second-minimum-time-to-reach-destination/description
// Time: O(n + e)
// Space: O(n)

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<Integer>[] adjList = new ArrayList[n + 1];
        List<Integer>[] visited = new ArrayList[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        int curr = 0, prev = 0, size, node;

        queue.offer(1);
        for(int idx = 1; idx < n + 1; idx++) {
            adjList[idx] = new ArrayList<>();
            visited[idx] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        while(!queue.isEmpty()) {
            size = queue.size();

            for(int idx = 0; idx < size; idx++) {
                node = queue.poll();

                if(node == n) {
                    if(prev == 1) {
                        return curr;
                    }
                    prev = 1;
                }

                for(int nei : adjList[node]) {
                    if(visited[nei].size() == 0 || (visited[nei].size() == 1 && visited[nei].get(0) != curr)) {
                        queue.offer(nei);
                        visited[nei].add(curr);
                    }
                }
            }

            if((curr / change) % 2 == 1) {
                curr += (change - curr % change);
            }
            curr += time;
        }

        return curr;
    }
}
