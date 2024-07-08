// Problem link: 
// Time: O(m * n * log(m * n))
// Space: O(m * n)
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length, newRow, newCol, newTime, time, row, col;
        int[] triplet;
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        Set<String> visited = new HashSet<>();
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        minHeap.offer(new int[]{0, 0, 0});
        
        while (!minHeap.isEmpty()) {
            triplet = minHeap.poll();
            time = triplet[0];
            row = triplet[1];
            col = triplet[2];
            
            if(visited.contains(row + " " + col))
                continue;
            
            if(row == rows - 1 && col == cols - 1)
                return time;
            
            visited.add(row + " " + col);
            
            for(int[] dir : directions) {
                newRow = row + dir[0];
                newCol = col + dir[1];
                
                if(newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                    newTime = Math.max(time, Math.abs(heights[row][col] - heights[newRow][newCol]));
                    minHeap.offer(new int[]{newTime, newRow, newCol});
                }
            }
        }
        
        return -1;
    }
}
