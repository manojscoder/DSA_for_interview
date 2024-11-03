// Problem link: https://leetcode.com/problems/minimum-cost-of-a-path-with-special-roads/description/
// Time: O(n ^ 2 log(n))
// Space: O(n)
class Solution {
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        int[] distance = new int[specialRoads.length];
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int result = Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1]), dist, x, y, index, cst, store[];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PQ.offer(new int[] {0, start[0], start[1], -1});

        while(!PQ.isEmpty()) {
            store = PQ.poll();
            dist = store[0];
            x = store[1];
            y = store[2];
            index = store[3];

            if(index != -1 && distance[index] < dist) {
                continue;
            }

            result = Math.min(result, Math.abs(x - target[0]) + Math.abs(y - target[1]) + dist);

            for(index = 0; index < specialRoads.length; index++) {
                store = specialRoads[index];
                cst = Math.abs(store[0] - x) + Math.abs(store[1] - y) + dist + store[4];
                if(distance[index] > cst) {
                    distance[index] = cst;
                    PQ.offer(new int[] {cst, store[2], store[3], index});
                }
            }
        }

        return result;
    }
}
