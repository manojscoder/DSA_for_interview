// Problem link: https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description
// Time: O(n log n)
// Space: O(n)
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int size = times.length, chair;
        Integer[] indexes = new Integer[size];

        for(int idx = 0; idx < size; idx++) {
            indexes[idx] = idx;
        }

        Arrays.sort(indexes, (a, b) -> Integer.compare(times[a][0], times[b][0]));
        PriorityQueue<Integer> minChair = new PriorityQueue<>();
        PriorityQueue<int[]> minLeaving = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for(int chr = 0; chr < size; chr++) {
            minChair.add(chr);
        }

        for(int index : indexes) {
            while(!minLeaving.isEmpty() && minLeaving.peek()[0] <= times[index][0]) {
                minChair.add(minLeaving.poll()[1]);
            }

            chair = minChair.poll();

            if(index == targetFriend) {
                return chair;
            }

            minLeaving.add(new int[] {times[index][1], chair});
        }

        return -1;
    }
}
