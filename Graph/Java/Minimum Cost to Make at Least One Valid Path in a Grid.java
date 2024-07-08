// Problem link: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/description/
// Time: O(n * m * log(n * m))
// Space: O(n * m)
class Solution {
    public int minCost(int[][] grid) {
        int[][] direction = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int rows = grid.length, cols = grid[0].length, rw, cl, row, col, cost;
        minHeap.offer(new int[] {0, 0, 0});
        boolean[][] visited = new boolean[rows][cols];

        while(!minHeap.isEmpty()) {
            int[] store = minHeap.poll();
            row = store[1];
            col = store[2];
            cost = store[0];

            if(visited[row][col])
                continue;
            
            if(row == rows - 1 && col == cols - 1)
                return cost;
            
            visited[row][col] = true;

            if(grid[row][col] == 1) {
                rw = row;
                cl = col + 1;
            } else if(grid[row][col] == 2) {
                rw = row;
                cl = col - 1;
            } else if(grid[row][col] == 3) {
                rw = row + 1;
                cl = col;
            } else {
                rw = row - 1;
                cl = col;
            }

            for(int[] dir : direction) {
                if(dir[0] + row >= 0 && dir[0] + row < rows && dir[1] + col >= 0 && dir[1] + col < cols) {
                    if(dir[0] + row == rw && dir[1] + col == cl) {
                        minHeap.offer(new int[] {cost, dir[0] + row, dir[1] + col});
                    } else {
                        minHeap.offer(new int[] {cost + 1, dir[0] + row, dir[1] + col});
                    }
                }
            }
        }

        return -1;
    }
}
