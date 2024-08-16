// Problem link: https://leetcode.com/problems/min-cost-to-connect-all-points/description/
// Time: O(n ^ 2 log E)
// Space: O(n)
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int cost = 0, size = points.length, dist;
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[] visit = new int[size];
        queue.offer(new int[] {0, 0});


        while(!queue.isEmpty()) {
            int[] pair = queue.poll();

            if(visit[pair[1]] == 1) {
                continue;
            }

            cost += pair[0];
            visit[pair[1]] = 1;

            for(int idx = 0; idx < size; idx++) {
                if(visit[idx] != 1) {
                    dist = Math.abs(points[pair[1]][0] - points[idx][0]) + Math.abs(points[pair[1]][1] - points[idx][1]);
                    queue.offer(new int[] {dist, idx});
                }
            }
        }

        return cost;
    }
}
