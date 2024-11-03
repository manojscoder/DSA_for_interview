// Problem link: https://leetcode.com/problems/find-minimum-time-to-reach-last-room-ii/description/
// Time: O(n * m * log(n * m))
// Space: O(n * m)
class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int rows = moveTime.length, cols = moveTime[0].length, rw, cl, row, col, dist, store[], time;
        int[][] distance = new int[rows][cols];
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for(int[] dis : distance) {
            Arrays.fill(dis, Integer.MAX_VALUE);
        }

        distance[0][0] = 0;
        PQ.offer(new int[] {0, 0, 0, 1});

        while(!PQ.isEmpty()) {
            store = PQ.poll();
            dist = store[0];
            row = store[1];
            col = store[2];
            time = store[3];

            if(distance[row][col] < dist) {
                continue;
            }
            else if(row == rows - 1 && col == cols - 1) {
                return dist;
            }

            for(int[] dir : directions) {
                rw = dir[0] + row;
                cl = dir[1] + col;

                if(rw >= 0 && rw < rows && cl >= 0 && cl < cols && distance[rw][cl] > Math.max(dist, moveTime[rw][cl]) + time) {
                    distance[rw][cl] = Math.max(dist, moveTime[rw][cl]) + time;
                    PQ.offer(new int[] {distance[rw][cl], rw, cl, time == 1 ? time + 1 : time - 1});
                }
            }
        }

        return distance[rows - 1][cols - 1];
    }
}
