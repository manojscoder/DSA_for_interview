// Problem link: https://leetcode.com/problems/maximal-score-after-applying-k-operations/description
// Time: O(k log n)
// Space: O(n)
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        long score = 0;

        for(int num : nums) {
            maxHeap.add(num);
        }

        for(int idx = 0; idx < k; idx++) {
            score += maxHeap.peek();
            maxHeap.add((int)Math.ceil(maxHeap.poll() / 3.0));
        }

        return score;
    }
}
