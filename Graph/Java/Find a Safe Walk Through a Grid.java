// Problem linK: https://leetcode.com/problems/find-a-safe-walk-through-a-grid/description/
// Time: O(n * m * h * log(n * m * h))
// Space: O(n * m * h)
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int rows = grid.size(), cols = grid.get(0).size();
        int[][] visited = new int[rows][cols];
        PriorityQueue<int[]> PQ = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int row, col, hea, rw, cl, new_hea, store[];
        PQ.offer(new int[] {health - grid.get(0).get(0), 0, 0});

        while(!PQ.isEmpty()) {
            store = PQ.poll();
            hea = store[0];
            row = store[1];
            col = store[2];

            if(row == rows - 1 && col == cols - 1) {
                return true;
            }

            visited[row][col] = 1;

            for(int[] dir : directions) {
                rw = row + dir[0];
                cl = col + dir[1];

                if(rw >= 0 && rw < rows && cl >= 0 && cl < cols) {
                    new_hea = hea - grid.get(rw).get(cl);

                    if(new_hea > 0 && visited[rw][cl] == 0) {
                        PQ.offer(new int[] {new_hea, rw, cl});
                        visited[rw][cl] = 1;
                    }
                }
            }
        }

        return false;
    }
}
