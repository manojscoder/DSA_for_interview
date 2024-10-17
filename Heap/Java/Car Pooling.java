// Problem link: https://leetcode.com/problems/car-pooling/description/
// Time: O(n log n)
// Space: O(n)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int size = trips.length, filled = 0;
        int[][] store = new int[size][3];

        for(int idx = 0; idx < size; idx++) {
            store[idx][0] = trips[idx][1];
            store[idx][1] = trips[idx][2];
            store[idx][2] = trips[idx][0];
        }

        Arrays.sort(store, (a, b) -> Integer.compare(a[0], b[0]));

        for(int[] trip : store) {
            while(!minHeap.isEmpty() && minHeap.peek()[0] <= trip[0]) {
                filled -= minHeap.poll()[1];
            }

            if(filled + trip[2] > capacity) {
                return false;
            }

            filled += trip[2];
            minHeap.offer(new int[] {trip[1], trip[2]});
        }

        return true;
    }
}
