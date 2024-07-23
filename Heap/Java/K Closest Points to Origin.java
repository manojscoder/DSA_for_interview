// Problem link: https://leetcode.com/problems/k-closest-points-to-origin/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> 
            Integer.compare(a[0] * a[0] + a[1] * a[1],
                            b[0] * b[0] + b[1] * b[1]));

        int[][] result = new int[k][2];

        for(int[] pair : points) {
            minHeap.offer(pair);
        }

        for(int idx = 0; idx < k; idx++) {
            int[] pair = minHeap.poll();
            result[idx][0] = pair[0];
            result[idx][1] = pair[1];
        }

        return result;
    }
}
