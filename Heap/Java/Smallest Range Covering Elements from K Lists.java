// Problem link: https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/description
// Time: O(n log k)
// Space: O(k)
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int maxNum = -1, small = 0, large = 0, size = Integer.MAX_VALUE, length = nums.size();

        for(int idx = 0; idx < length; idx++) {
            minHeap.add(new int[] {nums.get(idx).get(0), 0, idx});
            maxNum = Math.max(maxNum, nums.get(idx).get(0));
        }

        while(minHeap.size() >= length) {
            if(size > maxNum - minHeap.peek()[0]) {
                size = maxNum - minHeap.peek()[0];
                small = minHeap.peek()[0];
                large = maxNum;
            }

            int[] popped = minHeap.poll();

            if(popped[1] + 1 < nums.get(popped[2]).size()) {
                int newVal = nums.get(popped[2]).get(popped[1] + 1);
                minHeap.add(new int[] {newVal, popped[1] + 1, popped[2]});
                maxNum = Math.max(maxNum, newVal);
            }
        }

        return new int[] {small, large};
    } 
}
